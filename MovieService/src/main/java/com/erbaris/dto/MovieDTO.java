package com.erbaris.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.karandev.util.mapstruct.annotation.ToType;
import org.mapstruct.Mapping;

import java.time.LocalDate;

public class MovieDTO {

    public String name;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate sceneDate;
    public double cost;


}
