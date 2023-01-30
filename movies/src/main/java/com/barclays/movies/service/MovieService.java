package com.barclays.movies.service;

import com.barclays.movies.model.Movie;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);

    List<Movie> findAll();

    Movie findById(Long id);
}
