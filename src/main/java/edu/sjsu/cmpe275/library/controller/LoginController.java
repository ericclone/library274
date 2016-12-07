package edu.sjsu.cmpe275.library.controller;

import edu.sjsu.cmpe275.library.model.BookEntity;
import edu.sjsu.cmpe275.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String showRegister() {
        return "register";
    }
}
