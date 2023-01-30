package com.barclays.movies.repository;

import com.barclays.movies.model.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTypeRepository extends JpaRepository<MovieType, Long> {


}
