package com.erbaris.movie.data.entity;

import java.time.LocalDate;

public class MovieSave {

    public String movieName;
    public LocalDate sceneDate;
    public long rating;
    public int real;
    public double imdb;

    public MovieSave(long movieId, String movieName, LocalDate sceneDate, long rating, int real, double imdb) {
        this.movieName = movieName;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.real = real;
        this.imdb = imdb;
    }


}
