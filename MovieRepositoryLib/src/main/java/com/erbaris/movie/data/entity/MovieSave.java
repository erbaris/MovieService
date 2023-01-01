package com.erbaris.movie.data.entity;

import java.time.LocalDate;

public class MovieSave {

    public String movieName;
    public LocalDate sceneDate;
    public long rating;
    public double cost;
    public double imdb;

    public MovieSave(long movieId, String movieName, LocalDate sceneDate, long rating, double cost, double imdb) {
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }


}
