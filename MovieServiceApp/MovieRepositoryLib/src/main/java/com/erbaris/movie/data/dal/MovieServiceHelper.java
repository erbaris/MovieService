package com.erbaris.movie.data.dal;

import com.erbaris.movie.data.BeanName;
import com.erbaris.movie.data.entity.Director;
import com.erbaris.movie.data.entity.DirectorSave;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
import com.erbaris.movie.data.repository.IMovieRepository;
import org.springframework.stereotype.Component;

@Component(BeanName.MOVIE_SERVICE_HELPER)
public class MovieServiceHelper {
    private final IMovieRepository m_movieRepository;


    public MovieServiceHelper(IMovieRepository movieRepository) {
        m_movieRepository = movieRepository;
    }

    public MovieSave saveMovie(MovieSave movieSave)
    {
        m_movieRepository.saveMovie(movieSave);

        return movieSave;
    }
    public DirectorSave saveDirector(DirectorSave directorSave)
    {
        m_movieRepository.saveDirector(directorSave);

        return directorSave;
    }

    public long countMovies()
    {
        return m_movieRepository.count();
    }

    public Iterable<Movie> findMovieByMonth(int month)
    {
        return m_movieRepository.findByMonth(month);
    }

    public Iterable<Movie> findMovieByYear(int year)
    {
        return m_movieRepository.findByYear(year);
    }
    public Iterable<Movie> findMovieByMonthYear(int month, int year)
    {
        return m_movieRepository.findMonthYear(month, year);
    }
    public Iterable<Movie> findMovieByYearBetween(int begin, int end)
    {
        return m_movieRepository.findBetweenYear(begin, end);
    }

    public Iterable<Director> findDirectorByMovieId(long id)
    {
        return m_movieRepository.findDirectorByMovideId(id);
    }

    public Iterable<Movie> findMoviesByDirectorId(long id)
    {
        return m_movieRepository.findMovieByDirectorId(id);
    }
}
