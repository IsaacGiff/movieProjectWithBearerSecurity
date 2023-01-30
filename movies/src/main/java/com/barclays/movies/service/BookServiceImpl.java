package com.barclays.movies.service;

import com.barclays.movies.model.Book;
import com.barclays.movies.repository.BookRepository;
import com.barclays.movies.repository.BookTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookTypeRepository bookTypeRepository;

    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    public BookServiceImpl(BookRepository bookRepository, BookTypeRepository bookTypeRepository) {
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
    }

    @Override
    public List<Book> findAll() {
        logger.info("entering book findall");
        List<Book> books = bookRepository.findAll();

        logger.info("Exiting findAll for books");
        return books;
    }

    @Override
    public Book save(Book book){
        logger.info("entering");
        book = bookRepository.saveAndFlush(book);
        return book;
    }

    @Override
    public Book findById(Long id){

        Optional<Book> bookOptional = bookRepository.findById(id);
        Book book = null;

        if (bookOptional.isPresent()){
            book = bookOptional.get();
        }
        else {
            book = bookRepository.findById(id).get();
            book.setId(null);
        }
        return book;
    }

    @Override
    public Book findByTitle(String name){

        Optional<Book> bookOptional = bookRepository.findByTitle(name);
        Book book = null;

        if (bookOptional.isPresent()){
            book = bookOptional.get();
        }
        else {
            book = bookRepository.findById(1L).get();
            book.setId(null);
        }
        return book;


    }




}
