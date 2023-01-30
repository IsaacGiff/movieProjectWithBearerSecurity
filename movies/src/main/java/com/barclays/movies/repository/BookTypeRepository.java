package com.barclays.movies.repository;

import com.barclays.movies.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTypeRepository extends JpaRepository<BookType, Long> {
}
