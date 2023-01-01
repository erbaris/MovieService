package com.erbaris.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class MovieSaveDTO {
    public String name;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;
    public long rating;
    public double cost;
    public double imdb;

}
