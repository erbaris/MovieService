package com.erbaris.movie.data.repository;

import com.erbaris.movie.data.entity.Movie;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRepository extends ICrudRepository<Movie, Long>{
    Optional<Movie> findByMonth(int month);
}
