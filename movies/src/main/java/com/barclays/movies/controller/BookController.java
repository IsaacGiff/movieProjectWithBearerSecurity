package com.barclays.movies.controller;

import com.barclays.movies.model.Book;
import com.barclays.movies.model.BookType;
import com.barclays.movies.repository.BookTypeRepository;
import com.barclays.movies.repository.MovieTypeRepository;
import com.barclays.movies.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;




@Controller
@RequestMapping("/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;
    private final BookTypeRepository bookTypeRepository;

    public BookController(BookService bookService, BookTypeRepository bookTypeRepository) {
        this.bookService = bookService;
        this.bookTypeRepository = bookTypeRepository;
    }

    @ModelAttribute("bookTypeList")
    public List<BookType> getBookTypeList() {return bookTypeRepository.findAll();}

    @GetMapping
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("books");

        List<Book> books = bookService.findAll();

        modelAndView.addObject("books", books);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Book book = bookService.findById(id);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        ModelAndView modelAndView = new ModelAndView("books");
        modelAndView.addObject("books", bookList);

        return modelAndView;
    }





}
