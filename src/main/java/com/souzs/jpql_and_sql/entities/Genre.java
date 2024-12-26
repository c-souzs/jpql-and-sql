package com.souzs.jpql_and_sql.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private Long id;
    private String description;

    @OneToMany(mappedBy = "genre")
    List<Movie> movies = new ArrayList<>();

    public Genre() {
    }

    public Genre(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", movies=" + movies.stream()
                    .map(Movie::getName)
                    .reduce("", (names, movieName) -> names + movieName + " ") +
                '}';
    }
}
