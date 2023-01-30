package com.barclays.movies.service;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.repository.MovieRepo;
import com.barclays.movies.repository.MovieTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);


    private final MovieRepo movieRepo;
    private final MovieTypeRepository movieTypeRepository;

    @Autowired
    public MovieServiceImpl(MovieRepo movieRepo, MovieTypeRepository movieTypeRepository) {
        this.movieRepo = movieRepo;
        this.movieTypeRepository = movieTypeRepository;
    }

    @Override
    public Movie save(Movie movie) {
        logger.info("entering the save");

        movie = movieRepo.saveAndFlush(movie);

        logger.info("Exiting the save");
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        logger.info("entering findAll");

        List<Movie> movies = movieRepo.findAll();

        logger.info("exiting findAll");
        return movies;
    }

    @Override
    public Movie findById(Long id) {
        logger.info("entering findById");

        Movie movie = null;
        Optional<Movie> optMovie = movieRepo.findById(id);

        if(optMovie.isPresent()){
            movie = optMovie.get();
        }
        else {
            movie = movieRepo.getReferenceById(1L);
        }

        logger.info("exiting findById");
        return movie;
    }
}
