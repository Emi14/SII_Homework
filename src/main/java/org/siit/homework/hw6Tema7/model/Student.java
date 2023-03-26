package org.siit.homework.hw6Tema7.model;

import org.siit.homework.hw6Tema7.exception.DateOfBirthException;
import org.siit.homework.hw6Tema7.exception.FirstNameException;
import org.siit.homework.hw6Tema7.exception.GenderException;
import org.siit.homework.hw6Tema7.exception.LastNameException;
import org.siit.homework.hw6Tema7.utils.Gender;

public class Student {
    private Long cnp;
    private String firstName;
    private String lastName;
    private Integer dateOfBirth;
    private Gender gender;


    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new FirstNameException();
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new LastNameException();
        }
        this.lastName = lastName;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        Integer currentYear = 2023;
        if (dateOfBirth < 1900 || dateOfBirth > currentYear - 18) {
            throw new DateOfBirthException();
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
            this.gender = Gender.valueOf(gender.toUpperCase());
        } else {
            throw new GenderException();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "cnp=" + cnp +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
