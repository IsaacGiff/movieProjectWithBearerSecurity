package com.barclays.movies.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
@Table(name = "BOOK_TYPE")
public class BookType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TYPE")
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
