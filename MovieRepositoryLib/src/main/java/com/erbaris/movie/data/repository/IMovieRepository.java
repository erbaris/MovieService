package com.erbaris.movie.data.repository;

import com.erbaris.movie.data.entity.Director;
import com.erbaris.movie.data.entity.DirectorSave;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

public interface IMovieRepository extends ICrudRepository<Movie, Long>{
    Iterable<Movie> findByMonth(int month);
    Iterable<Movie> findByYear(int year);
    Iterable<Movie> findMonthYear(int month, int year);
    Iterable<Movie> findBetweenYear(int startYear, int endYear);
    Iterable<Director> findDirectorByMovideId(long id);
    Iterable<Movie> findMovieByDirectorId(long id);
    public DirectorSave saveDirector(DirectorSave director);
    public MovieSave saveMovie(MovieSave movieSave);
}
