package com.erbaris.android.app.androidclient.data.entity;

import java.time.LocalDate;

public class Movie {
    public String name;
    public String sceneDate;
    public String cost;


    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", sceneDate='" + sceneDate + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}
