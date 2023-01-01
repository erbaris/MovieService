package com.erbaris.movie.data.entity;

import java.time.LocalDate;

public class Movie {
    public long movieId;
    public String movieName;
    public LocalDate sceneDate;
    public long rating;
    public double cost;
    public double imdb;

    public Movie(long movieId, String movieName, LocalDate sceneDate, long rating, double cost, double imdb) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

}
