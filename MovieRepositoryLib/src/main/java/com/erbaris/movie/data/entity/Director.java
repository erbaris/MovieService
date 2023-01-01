package com.erbaris.movie.data.entity;

import java.time.LocalDate;

public class Director {
    public String fullName;
    public LocalDate birthDate;

    public Director(String fullName, LocalDate bithDate) {
        this.fullName = fullName;
        this.birthDate = bithDate;
    }
}

