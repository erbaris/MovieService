package com.erbaris.service;

import com.erbaris.dto.CountDTO;
import com.erbaris.dto.MovieDTO;
import com.erbaris.dto.MoviesDTO;
import com.erbaris.mapper.IMovieMapper;
import com.erbaris.movie.data.dal.MovieServiceHelper;
import org.csystem.util.collection.CollectionUtil;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieServiceHelper m_movieServiceHelper;
    private final IMovieMapper m_iMovieMapper;

    public MovieService(MovieServiceHelper movieServiceHelper, IMovieMapper iMovieMapper) {
        m_movieServiceHelper = movieServiceHelper;
        m_iMovieMapper = iMovieMapper;
    }
    public CountDTO countMovies()
    {
        return m_iMovieMapper.toCountDTO(m_movieServiceHelper.countMovies());
    }
    public MoviesDTO findMoviesByMonth(int month)
    {
        return m_iMovieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMovieByMonth(month), m_iMovieMapper::toMovieDTO));
    }
    public MoviesDTO findMoviesByYear(int year)
    {
        return m_iMovieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMovieByYear(year), m_iMovieMapper::toMovieDTO));
    }
    public MoviesDTO findMoviesByMonthYear(int month, int year)
    {
        return m_iMovieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMovieByMonthYear(month, year), m_iMovieMapper::toMovieDTO));
    }
    public MoviesDTO findMoviesByYearBetween(int begin, int end)
    {
        return m_iMovieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMovieByYearBetween(begin, end), m_iMovieMapper::toMovieDTO));
    }
    public MoviesDTO findMoviesByDirectorId(long id)
    {
        return m_iMovieMapper.toMoviesDTO(CollectionUtil.toList(m_movieServiceHelper.findMoviesByDirectorId(id), m_iMovieMapper::toMovieDTO));
    }
    public MovieDTO saveMovie(MovieDTO movieDTO)
    {
        return m_iMovieMapper.toMovieDTO(m_iMovieMapper.toMovie(m_movieServiceHelper.saveMovie(m_iMovieMapper.toMovieSave(movieDTO))));
    }
}
