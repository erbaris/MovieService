package com.erbaris.android.app.androidclient.api;

import com.erbaris.android.app.androidclient.data.entity.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//http://192.168.1.152:50500/api/movies/movie/find/sdate/year?y=2021
public interface IMovieByYearSearch {
    @GET("/api/movies/movie/find/sdate/year")
    Call<Movies> findByYear(@Query("y") String year);
}
