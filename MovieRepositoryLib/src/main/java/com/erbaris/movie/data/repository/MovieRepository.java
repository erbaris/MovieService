package com.erbaris.movie.data.repository;

import com.erbaris.movie.data.BeanName;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.mapper.IMovieMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.MOVIE_REPOSITORY)
public class MovieRepository implements IMovieRepository{
    private static final String COUNT_SQL = "select count(*) from movies";
    private static final String FIND_BY_MONTH = "select * from veterinarians where date_part('month', scene_date)";

    private static final String SAVE_MOVIE = "insert into movies (name, scene_date, rating, cost, imdb) values (:movieName, :sceneDate, :rating, :cost, :imdb)";

    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;

    private final IMovieMapper m_movieMapper;

    public MovieRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, IMovieMapper movieMapper) {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        m_movieMapper = movieMapper;
    }

    private static Movie getMovie(ResultSet rs) throws SQLException
    {
        var movieId = rs.getLong(1);
        var movieName = rs.getString(2);
        var sceneDate = rs.getDate(3).toLocalDate();
        var rating = rs.getLong(4);
        var cost = rs.getInt(5);
        var imdb = rs.getDouble(6);


        return new Movie(movieId, movieName, sceneDate, rating, cost, imdb);
    }

    private static void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException
    {
        do
            movies.add(getMovie(rs));
        while (rs.next());
    }

    @Override
    public long count()
    {
        var counts = new ArrayList<Long>();

        m_namedParameterJdbcTemplate.query(COUNT_SQL, rs -> {counts.add(rs.getLong(1));});

        return counts.get(0);
    }

    @Override
    public Optional<Movie> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();


        paramMap.put("month", month);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies.isEmpty() ? Optional.empty() : Optional.of(movies.get(0));
    }

    @Override
    public <S extends Movie> S save(S movie) {
        var paramSource = new BeanPropertySqlParameterSource(movie);

        paramSource.registerSqlType("sceneDate", Types.DATE);
        paramSource.registerSqlType("imdb", Types.DOUBLE);
        m_namedParameterJdbcTemplate.update(SAVE_MOVIE, paramSource);

        return movie;
    }

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public void delete(Movie entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> id) {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }



    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }
}

