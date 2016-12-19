package edu.sjsu.cmpe275.library.controller;

import edu.sjsu.cmpe275.library.exception.BookNotFoundException;
import edu.sjsu.cmpe275.library.model.BookEntity;
import edu.sjsu.cmpe275.library.model.CheckOutEntity;
import edu.sjsu.cmpe275.library.model.UserEntity;
import edu.sjsu.cmpe275.library.repository.BookRepository;
import edu.sjsu.cmpe275.library.repository.CheckOutRepository;
import edu.sjsu.cmpe275.library.repository.UserRepository;
import edu.sjsu.cmpe275.library.util.Util;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CheckOutRepository checkOutRepository;

    @RequestMapping(value = "/createbook", method = RequestMethod.GET)
    public ModelAndView getCreateBook() {
        return new ModelAndView("bookform", "command", new BookEntity());
    }

    @RequestMapping(value = "/createbook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute BookEntity book, ModelMap modelMap, Principal principal) {
        System.out.println(principal.getName());
        UserEntity currentUser = userRepository.findByEmail(principal.getName());
        book.setCreatedBy(currentUser);
        book.setUpdatedBy(currentUser);
        bookRepository.saveAndFlush(book);
//        currentUser.getBooksCreated().add(book);
//        currentUser.getBooksUpdated().add(book);
//        userRepository.saveAndFlush(currentUser);
        modelMap.addAttribute("book", book);
        return "redirect:/show/" + book.getId();
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showOneBook(@PathVariable("id") Long id, ModelMap modelMap) {
        BookEntity book = bookRepository.findOne(id);
        if (book == null) {
            throw new BookNotFoundException();
        }
        modelMap.addAttribute("book", book);
        return "showbook";
    }

    @RequestMapping(value = "/list")
    public String showList(ModelMap model, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        if (user.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
            // This is a librarian
            Collection<BookEntity> books = new ArrayList<>(user.getBooksCreated());
            for (BookEntity book : user.getBooksUpdated()) {
                if (!books.contains(book)) {
                    books.add(book);
                }
            }
            model.put("admin", "true");
            model.put("booklist", books);
            return "list";
        }
        else {
            Collection<BookEntity> books = bookRepository.findAll();
            model.put("user", "true");
            model.put("booklist", books);
            return "list";
        }
    }

    @RequestMapping(value = "/update/{id}")
    public ModelAndView showUpdate(ModelMap modelMap, @PathVariable("id") Long id) {
        BookEntity book = bookRepository.findById(id);
        if (null == book) {
            throw new BookNotFoundException();
        }
        return new ModelAndView("bookform", "command", book);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute BookEntity book, @PathVariable("id") Long id, ModelMap modelMap, Principal principal) {
        System.out.println(principal.getName());
        UserEntity currentUser = userRepository.findByEmail(principal.getName());
        book.setUpdatedBy(currentUser);
        UserEntity creator = bookRepository.findById(id).getCreatedBy();
        book.setCreatedBy(creator);
        bookRepository.saveAndFlush(book);
        modelMap.addAttribute("book", book);
        return "redirect:/show/" + book.getId();
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        try {
            System.out.println("deleting book with id " + id);
            bookRepository.delete(id);
            bookRepository.flush();
            System.out.println("done deleting book?");
        }
        catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        model.addAttribute("msg", "Book deleted successfully");
        return "redirect:/list";
    }

    @RequestMapping(value = "/checkout/{id}")
    public String checkOutBook(@PathVariable("id") Long id, Model model, Principal principal) {
        UserEntity currentUser = userRepository.findByEmail(principal.getName());
        if (currentUser.getAuthority().equalsIgnoreCase("ROLE_USER")) {
            BookEntity book = bookRepository.findById(id);
            CheckOutEntity checkOut = checkOutRepository.findByUserAndBook(currentUser, book);
            if (checkOut == null) {
                checkOut = new CheckOutEntity();
                checkOut.setBook(book);
                checkOut.setUser(currentUser);
                checkOut.setDueDate(Util.getDateAfter(3));
                checkOutRepository.saveAndFlush(checkOut);
                System.out.printf("book has %d checkouts.\n", book.getCheckOut().size());
                System.out.printf("user has %d checkouts.\n", currentUser.getCheckOut().size());
                model.addAttribute("success", "true");
            }
            else {
                model.addAttribute("error", "You have already checked out this book");
            }

            model.addAttribute("book", book);
        }
        return "checkedout";
    }

    @RequestMapping(value = "/checkouts")
    public String listCheckOuts(Model model, Principal principal) {
        UserEntity currentUser = userRepository.findByEmail(principal.getName());
        System.out.printf("user has %d checkouts.\n", currentUser.getCheckOut().size());
        Collection<CheckOutEntity> checkOuts = currentUser.getCheckOut();
        for (CheckOutEntity checkOut : checkOuts) {
            BookEntity book = checkOut.getBook();
            System.out.printf("%s has %d checkouts.\n", book.getTitle(), book.getCheckOut().size());
        }
        model.addAttribute("checkoutlist", checkOuts);
        return "checkouts";
    }

    @RequestMapping(value = "/return/{id}")
    public String returnBook(@PathVariable("id") Long id, Model model, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        BookEntity book = bookRepository.findById(id);
        CheckOutEntity checkOut = checkOutRepository.findByUser_IdAndBook_Id(user.getId(), id);
        if (checkOut != null) {
            checkOutRepository.delete(checkOut);
            checkOutRepository.flush();
            System.out.printf("book has %d checkouts.\n", book.getCheckOut().size());
            System.out.printf("user has %d checkouts.\n", user.getCheckOut().size());
            model.addAttribute("success", "true");
        }
        else {
            model.addAttribute("error", "You did not check out this book.");
        }
        model.addAttribute("book", book);
        return "returned";
    }
}
