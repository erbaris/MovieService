package com.erbaris.movie.data.repository;

import com.erbaris.movie.data.BeanName;
import com.erbaris.movie.data.entity.Director;
import com.erbaris.movie.data.entity.DirectorSave;
import com.erbaris.movie.data.entity.Movie;
import com.erbaris.movie.data.entity.MovieSave;
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
    private static final String FIND_BY_MONTH = "select * from movies where date_part('month', scene_date) = :month";
    private static final String FIND_BY_YEAR = "select * from movies where date_part('year', scene_date) = :year";
    private static final String FIND_BY_MONTH_YEAR = """
            select * from movies where date_part('month', scene_date) = :month\s
            and date_part('year', scene_date) = :year""";

    private static final String FIND_BY_YEAR_BETWEEN = "select * from movies where  date_part('year', scene_date) between :begin and :end";
    private static final String SAVE_MOVIE = "insert into movies (name, scene_date, rating, cost, imdb) values (:movieName, :sceneDate, :rating, :cost, :imdb)";

    private static final String SAVE_DIRECTOR = "insert into directors (first_name, middle_name, family_name, birth_date) values (:firstName, :middleName, :familyName, :birthDate)";
    private static final String FIND_DIRECTOR_BY_MOVIE_ID = "select * from get_directors_by_movie_id(:id)";
    private static final String FIND_MOVIE_BY_DIRECTOR_ID = """
                                                select
                                                m.movie_id, m.name, m.scene_date, m.rating, m.cost, m.imdb\s
                                                from movies m inner join movies_to_director mtd on mtd.movie_id = m.movie_id 
                                                where mtd.director_id = :id""";
    private final NamedParameterJdbcTemplate m_namedParameterJdbcTemplate;


    public MovieRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        m_namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static Movie getMovie(ResultSet rs) throws SQLException
    {
        var movieId = rs.getLong(1);
        var movieName = rs.getString(2);
        var sceneDate = rs.getDate(3).toLocalDate();
        var rating = rs.getLong(4);
        var cost = rs.getDouble(5);
        var imdb = rs.getDouble(6);


        return new Movie(movieId, movieName, sceneDate, rating, cost, imdb);
    }
    private static Director getDirector(ResultSet rs) throws SQLException
    {
        var fullName = rs.getString(1);
        var birthDate = rs.getDate(2).toLocalDate();

        return new Director(fullName, birthDate);
    }

    private static void fillMovies(ResultSet rs, List<Movie> movies) throws SQLException
    {
        do
            movies.add(getMovie(rs));
        while (rs.next());
    }
    private static void fillDirectors(ResultSet rs, List<Director> directors) throws SQLException
    {
        do
            directors.add(getDirector(rs));
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
    public Iterable<Movie> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();


        paramMap.put("month", month);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findByYear(int year) {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();


        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findMonthYear(int month, int year) {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("month", month);
        paramMap.put("year", year);

        m_namedParameterJdbcTemplate.query(FIND_BY_MONTH_YEAR, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }

    @Override
    public Iterable<Movie> findBetweenYear(int begin, int end) {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);

        m_namedParameterJdbcTemplate.query(FIND_BY_YEAR_BETWEEN, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;

    }

    @Override
    public MovieSave saveMovie(MovieSave movieSave) {
        var paramSource = new BeanPropertySqlParameterSource(movieSave);

        paramSource.registerSqlType("sceneDate", Types.DATE);
        paramSource.registerSqlType("imdb", Types.DOUBLE);
        paramSource.registerSqlType("cost", Types.DOUBLE);
        m_namedParameterJdbcTemplate.update(SAVE_MOVIE, paramSource);

        return movieSave;
    }

    @Override
    public DirectorSave saveDirector(DirectorSave director) {
        var paramSource = new BeanPropertySqlParameterSource(director);

        paramSource.registerSqlType("birthDate", Types.DATE);
        m_namedParameterJdbcTemplate.update(SAVE_DIRECTOR, paramSource);

        return director;
    }


    @Override
    public Iterable<Director> findDirectorByMovideId(long id) {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_DIRECTOR_BY_MOVIE_ID, paramMap, (ResultSet rs) -> fillDirectors(rs, directors));

        return directors;
    }

    @Override
    public Iterable<Movie> findMovieByDirectorId(long id) {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("id", id);

        m_namedParameterJdbcTemplate.query(FIND_MOVIE_BY_DIRECTOR_ID, paramMap, (ResultSet rs) -> fillMovies(rs, movies));

        return movies;
    }
    //------------------------------------------------------------------------------------------------------------------


    @Override
    public <S extends Movie> S save(S movie) {
        return null;
    }

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

