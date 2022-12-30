package com.erbaris.movie.data.dal;

import com.erbaris.movie.data.BeanName;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.mapper.IMovieMapper;
import com.erbaris.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(BeanName.MOVIE_SERVICE_HELPER)
public class MovieServiceHelper {
    private final IMovieRepository m_movieRepository;
    private final IMovieMapper m_movieMapper;

    public MovieServiceHelper(IMovieRepository movieRepository, IMovieMapper movieMapper) {
        m_movieRepository = movieRepository;
        m_movieMapper = movieMapper;
    }

    public long countMovies()
    {
        return m_movieRepository.count();
    }

    public Optional<Movie> findMovieByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }

}
