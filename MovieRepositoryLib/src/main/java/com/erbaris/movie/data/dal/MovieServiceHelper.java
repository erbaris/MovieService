package com.erbaris.movie.data.dal;

import com.erbaris.movie.data.BeanName;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
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

    public MovieSave save(MovieSave movieDTO)
    {
        m_movieRepository.save(m_movieMapper.toMovie(movieDTO));

        return movieDTO;
    }

    public long countMovies()
    {
        return m_movieRepository.count();
    }

    public Optional<Movie> findMovieByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }

    public Optional<Movie> findMovieByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }
    public Iterable<Movie> findMovieByMonthBetween(int begin, int end)
    {
        return m_movieRepository.findBetweenMonth(begin, end);
    }
    public Iterable<Movie> findMovieByYearBetween(int begin, int end)
    {
        return m_movieRepository.findBetweenYear(begin, end);
    }

}
