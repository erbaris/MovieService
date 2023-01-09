package com.erbaris.mapper;

import com.erbaris.dto.CountDTO;
import com.erbaris.dto.MovieDTO;
import com.erbaris.dto.MovieSaveDTO;
import com.erbaris.dto.MoviesDTO;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
import com.karandev.util.mapstruct.annotation.ToType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper {
    @Mapping(source = "movieName", target = "name")
    MovieDTO toMovieDTO(Movie movie);
    Movie toMovie(MovieSave movieSave);
    @Mapping(source = "name", target = "movieName")
    MovieSave toMovieSave(MovieSaveDTO movieSaveDTO);


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
