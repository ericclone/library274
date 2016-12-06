package edu.sjsu.cmpe275.library.controller;

import edu.sjsu.cmpe275.library.model.BookDao;
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
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/createbook", method = RequestMethod.GET)
    public ModelAndView getCreateBook() {
       return new ModelAndView("createbook", "command", new BookEntity());
    }

    @RequestMapping(value = "/createbook", method = RequestMethod.POST)
    public String createBook(@ModelAttribute BookEntity book, ModelMap model) {
       model.addAttribute("id", book.getId());
       model.addAttribute("isbn", book.getIsbn());
       model.addAttribute("author", book.getAuthor());
       model.addAttribute("title", book.getTitle());
       model.addAttribute("callnumber", book.getCallNumber());
       model.addAttribute("publisher", book.getPublisher());
       model.addAttribute("year", book.getYear());
       model.addAttribute("location", book.getLocation());
       model.addAttribute("numberofcopies", book.getNumberOfCopies());
       model.addAttribute("status", book.getStatus());
       model.addAttribute("keywords", book.getKeywords());
       model.addAttribute("coverurl", book.getCoverUrl());

       bookRepository.saveAndFlush(book);

       return "showbook";
    }
}
