package edu.sjsu.cmpe275.library.controller;

import edu.sjsu.cmpe275.library.exception.BookNotFoundException;
import edu.sjsu.cmpe275.library.model.BookEntity;
import edu.sjsu.cmpe275.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/createbook", method = RequestMethod.GET)
    public ModelAndView getCreateBook() {
       return new ModelAndView("createbook", "command", new BookEntity());
    }

    @RequestMapping(value = "/createbook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute BookEntity book, ModelMap modelMap) {
        bookRepository.saveAndFlush(book);
        modelMap.addAttribute("book", book);
        return "redirect:/showbook/" + book.getId();
    }

    @RequestMapping(value = "/showbook/{id}", method = RequestMethod.GET)
    public String showOneBook(@PathVariable("id") Long id, ModelMap modelMap) {
        BookEntity book = bookRepository.findOne(id);
        if (book == null) {
            throw new BookNotFoundException();
        }
        modelMap.addAttribute("book", book);
        return "showbook";
    }
}
