package com.erbaris.movie.data.entity;

import java.time.LocalDate;
import java.util.Optional;

public class DirectorSave {
    public String firstName;
    public String middleName;
    public String familyName;
    public LocalDate birthDate;

    public DirectorSave(String firstName, String middleName, String familyName, LocalDate birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.birthDate = birthDate;
    }
}
