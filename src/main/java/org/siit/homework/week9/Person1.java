package org.siit.homework.week9;

import java.time.LocalDate;

public class Person1 {
    private String name;
    private String surname;
    public LocalDate dob;
    public Person1() {
    }
    public Person1(String name, String surname, LocalDate dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }




    public int compareTo(Person1 other) {
        int surnameCompare = surname.compareTo(other.surname);
        if (surnameCompare != 0) {
            return surnameCompare;
        } else {
            return name.compareTo(other.name);
        }
    }
}
