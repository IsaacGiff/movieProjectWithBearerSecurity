package com.barclays.movies.service;

import com.barclays.movies.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book save(Book book);

    Book findById(Long id);

    Book findByTitle(String name);
}
