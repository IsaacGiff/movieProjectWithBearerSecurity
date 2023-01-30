package com.barclays.movies.model;

public class MovieDTO {

    private final Long id;
    private final String title;

    public MovieDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
