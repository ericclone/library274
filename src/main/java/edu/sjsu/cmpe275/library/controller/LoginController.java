package edu.sjsu.cmpe275.library.controller;

import edu.sjsu.cmpe275.library.event.OnRegistrationCompleteEvent;
import edu.sjsu.cmpe275.library.model.UserEntity;
import edu.sjsu.cmpe275.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebResult;
import java.security.Principal;
import java.util.Collection;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public ModelAndView showRegister() {
//        return new ModelAndView("register", "user", new UserEntity());
      return new ModelAndView("register", "command", new UserEntity());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView doRegister(@ModelAttribute UserEntity user, ModelMap modelMap, WebRequest request) {
        System.out.println(user.getEmail());
        System.out.println(user.getUnivId());
        UserEntity existingUser;
        if (userRepository.findByEmail(user.getEmail()) != null) {
            modelMap.put("error", "Email already registered");
            modelMap.put("command", user);
            System.out.printf("Email already registered");
            System.out.println(modelMap.keySet());
            return new ModelAndView("register", modelMap);
        }

        Collection<UserEntity> existingUsers;
        if ((existingUsers = userRepository.findAllByUnivId(user.getUnivId())).size() != 0) {
            for (UserEntity u : existingUsers) {
                if (hasSjsuEmail(u) == hasSjsuEmail(user)) {
                    modelMap.put("error", "University ID already registered for the same access level");
                    modelMap.put("command", user);
                    System.out.println("duplicate university id");
                    System.out.println(modelMap.keySet());
                    return new ModelAndView("register", modelMap);
                }
            }
        }
        if (hasSjsuEmail(user)) {
            user.setAuthority("ROLE_ADMIN");
        } else {
            user.setAuthority("ROLE_USER");
        }

        user.setVerificationToken(UUID.randomUUID().toString());
        UserEntity savedUser = userRepository.saveAndFlush(user);
        if (null == savedUser) {
            modelMap.put("error", "Cannot create new user");
            modelMap.put("command", user);
            return new ModelAndView("register", modelMap);
        }
        try {
            String appUrl = request.getContextPath();
            System.out.println("Publishing event: " + eventPublisher + "\n" + eventPublisher.getClass().getName());
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent
                    (savedUser, appUrl));
        } catch (Exception me) {
            System.out.println(me.getCause());
            System.out.println(me.getMessage());
            me.printStackTrace();
            return new ModelAndView("emailError", "user", user);
        }

        return new ModelAndView("reg_succ", "user", user);
    }

    @RequestMapping(value = "/confirm")
    public String confirmUser(@Param("token") String token) {
        System.out.println("token: " + token);
        UserEntity user = userRepository.findByVerificationToken(token);
        if (null == user) {
            System.out.println("User is not found");
            return "usernotfound";
        }
        user.setEnabled(true);
        UserEntity newUser = userRepository.saveAndFlush(user);
        if (newUser != null) {
            return "verified";
        }
        return "usernotfound";
    }


    private boolean hasSjsuEmail(UserEntity u) {
        String s = u.getEmail();
        return s.length() > 9 && s.substring(s.length() - 9).equalsIgnoreCase("@sjsu.edu");
    }
}
