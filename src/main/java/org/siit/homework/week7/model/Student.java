package org.siit.homework.week7.model;

import org.siit.homework.week7.enums.Gender;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String id) {
        validateName(firstName, "First Name");
        validateName(lastName, "Last Name");
        validateDateOfBirth(dateOfBirth);
        validateGender(gender);
        validateId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First Name");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last Name");
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        validateGender(gender);
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    private void validateName(String name, String fieldName) throws IllegalArgumentException {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " should not be empty");
        }
    }

    private void validateGender(Gender gender) throws IllegalArgumentException {
        if (gender == null) {
            throw new IllegalArgumentException("Gender should not be null");
        }
    }

    private void validateId(String id) throws IllegalArgumentException {
        // Validation code goes here
    }

    private void validateDateOfBirth(LocalDate dob) throws IllegalArgumentException {
        int currentYear = LocalDate.now().getYear();
        int minBirthYear = currentYear - 18 - 100;
        int maxBirthYear = currentYear - 18;
        if (dob.isBefore(LocalDate.of(minBirthYear, 1, 1))) {
            throw new IllegalArgumentException("Date of birth is too old");
        }
        if (dob.isAfter(LocalDate.of(maxBirthYear, 12, 31))) {
            throw new IllegalArgumentException("Date of birth is in the future");
        }
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(dateOfBirth, now).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", id='" + id + '\'' +
                '}';
    }
}

