package com.erbaris.mapper;

import com.erbaris.dto.CountDTO;
import com.erbaris.dto.MovieDTO;
import com.erbaris.dto.MoviesDTO;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper {
    MovieDTO toMovieDTO(Movie movie);
    Movie toMovie(MovieSave movieSave);
    MovieSave toMovieSave(MovieDTO movieDTO);

    default MoviesDTO toMoviesDTO(List<MovieDTO> movies)
    {
        var dto = new MoviesDTO();
        dto.movies = movies;
        return dto;
    }
    default CountDTO toCountDTO(long count)
    {
        return new CountDTO(count);
    }
}
