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

    public String getMovieName() {
        return movieName;
    }

    public LocalDate getSceneDate() {
        return sceneDate;
    }

    public long getRating() {
        return rating;
    }

    public double getCost() {
        return cost;
    }

    public double getImdb() {
        return imdb;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setSceneDate(LocalDate sceneDate) {
        this.sceneDate = sceneDate;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }
}
