package com.erbaris.director.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class DirectorDTO {
    public String fullName;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    public LocalDate birthDate;
}
