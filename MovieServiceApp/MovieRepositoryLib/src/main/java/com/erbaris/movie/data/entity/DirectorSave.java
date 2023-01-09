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

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
