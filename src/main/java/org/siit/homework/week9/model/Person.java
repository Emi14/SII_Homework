package org.siit.homework.week9.model;

public class Person {

    String firstName;
    String lastName;
    int monthOfBirth;

    public Person(String firstName, String lastName, int monthOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthOfBirth = monthOfBirth;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }
}
