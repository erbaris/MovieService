package com.erbaris.controller;

import com.erbaris.dto.CountDTO;
import com.erbaris.dto.MovieDTO;
import com.erbaris.dto.MovieSaveDTO;
import com.erbaris.dto.MoviesDTO;
import com.erbaris.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    private final MovieService m_movieService;

    public MovieController(MovieService movieService) {
        m_movieService = movieService;
    }

    @GetMapping("movie/count")
    public CountDTO count()
    {
        return m_movieService.countMovies();
    }
    @GetMapping("movies/find/sdate/month")
    public MoviesDTO findByMonth(@RequestParam("m") int month)
    {
        return m_movieService.findMoviesByMonth(month);
    }
    @GetMapping("movie/find/sdate/year")
    public MoviesDTO findByYear(@RequestParam("y") int year)
    {
        return m_movieService.findMoviesByYear(year);
    }
    @GetMapping("movie/find/sdate/my")
    public MoviesDTO findByMonthYear(@RequestParam("month") int month,@RequestParam("year") int year)
    {
        return m_movieService.findMoviesByMonthYear(month, year);
    }
    @GetMapping("movie/find/sdate/year/between")
    public MoviesDTO findByYearBetween(@RequestParam("begin")int begin,@RequestParam("end") int end)
    {
        return m_movieService.findMoviesByYearBetween(begin, end);
    }
    @GetMapping("movie/find/director")
    public MoviesDTO findByDirectorId(@RequestParam("id") long id)
    {
        return m_movieService.findMoviesByDirectorId(id);
    }
    @PostMapping("movie/save")
    public MovieSaveDTO saveMovie(@RequestBody MovieSaveDTO movieSaveDTO)
    {
        return m_movieService.saveMovie(movieSaveDTO);
    }
}
