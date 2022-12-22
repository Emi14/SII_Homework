package org.siit.homework.week7.student;

import java.util.Objects;

public class Student {
    String firstName;
    String lastName;
    int birthDate;
    String gender;
    String cnp;

    public Student(String firstName, String lastName, int birthDate, String gender, String cnp) {

        this.firstName = firstName.toUpperCase().trim();
        this.lastName = lastName.toUpperCase().trim();
        this.birthDate = birthDate;
        this.gender = gender.trim();
        this.cnp = cnp.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return cnp.equals(student.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "\n == Student ==" +
                "\n First Name: " + firstName +
                "\n Last Name: " + lastName +
                "\n Birth Date: " + birthDate +
                "\n Gender: " + gender +
                "\n Student ID: " + cnp;
    }
}

