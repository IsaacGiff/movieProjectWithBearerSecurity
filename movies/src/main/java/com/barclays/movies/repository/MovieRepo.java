package com.barclays.movies.repository;

import com.barclays.movies.model.Movie;
import com.barclays.movies.model.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("SELECT new com.barclays.movies.model.MovieDTO(m.id, m.title) FROM Movie m WHERE m.id = :id")
    MovieDTO findMovieDTOById(Long id);

}
