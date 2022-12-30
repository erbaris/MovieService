package com.erbaris.movie.data.mapper;

import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
import com.karandev.util.mapstruct.IOptionalMapper;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MovieMapperImpl", componentModel = "spring")
public interface IMovieMapper extends IOptionalMapper {

    Movie toMovie(MovieSave movieSave);
}
