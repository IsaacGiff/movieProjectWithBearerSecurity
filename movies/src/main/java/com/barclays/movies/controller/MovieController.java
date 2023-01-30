package com.barclays.movies.controller;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieType;
import com.barclays.movies.repository.MovieTypeRepository;
import com.barclays.movies.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;
    private final MovieTypeRepository movieTypeRepository;

    public MovieController(MovieService movieService, MovieTypeRepository movieTypeRepository) {
        this.movieService = movieService;
        this.movieTypeRepository = movieTypeRepository;
    }

    @ModelAttribute("movieTypeList")
    public List<MovieType> getMovieTypeList() {
        return movieTypeRepository.findAll();
    }

    @GetMapping
    public ModelAndView get() {
        ModelAndView modelAndView = new ModelAndView("movies");

        List<Movie> movies = movieService.findAll();

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView get(@PathVariable Long id) {

        Movie movie = movieService.findById(id);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);

        ModelAndView modelAndView = new ModelAndView("movies");
        modelAndView.addObject("movies", movieList);

        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@PathParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("addMovie");

        Movie movie = movieService.findById(id);

        modelAndView.addObject("movie", movie);

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("addMovie");
        Movie movie = movieService.findById(0L);
        modelAndView.addObject("movie", movie);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView post(@Valid @ModelAttribute Movie movie, BindingResult result) {
        logger.info("Entering post");
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("addMovie");
            logger.info("there were errors in the movie object");
        } else {
            logger.debug("Title: " + movie.getTitle());

            modelAndView.setViewName("addMovie");

            movie = movieService.save(movie);
            modelAndView.addObject("addMovieSuccess", true);
            modelAndView.addObject("addMovieTitle", movie.getTitle());

            modelAndView.addObject("movie", movie);
        }
        logger.info("Exiting post");
        return modelAndView;
    }


}
