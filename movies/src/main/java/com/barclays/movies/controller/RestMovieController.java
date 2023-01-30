package com.barclays.movies.controller;

import com.barclays.movies.model.MovieDTO;
import com.barclays.movies.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestMovieController {

    private final MovieRepo movieRepo;

    public RestMovieController(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    @GetMapping("/{id}")
    public MovieDTO get(@PathVariable Long id){
        return movieRepo.findMovieDTOById(id);
    }
}
