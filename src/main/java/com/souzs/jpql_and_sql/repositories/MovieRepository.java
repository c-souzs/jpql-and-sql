package com.souzs.jpql_and_sql.repositories;

import com.souzs.jpql_and_sql.dto.MovieMinDTO;
import com.souzs.jpql_and_sql.entities.Movie;
import com.souzs.jpql_and_sql.projections.MovieMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(nativeQuery = true, value = "SELECT m.id, m.name " +
            "FROM movies m JOIN genres g ON m.id_genres = g.id " +
            "WHERE description = :genre")
    List<MovieMinProjection> searchByGenreNameNative(String genre);

    @Query("SELECT new com.souzs.jpql_and_sql.dto.MovieMinDTO(obj.id, obj.name) " +
            "FROM Movie obj " +
            "WHERE obj.genre.description = :genre")
    List<MovieMinDTO> searchByGenreNameJPQL(String genre);
}
