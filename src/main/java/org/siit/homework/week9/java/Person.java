package org.siit.homework.week9.java;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private Date date;

    public Person() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                '}';
    }

    public int compareTo(Person o2) {
        String fullName = this.firstName+" "+this.lastName;
        String fullNameO2 = o2.getFirstName() + " " + o2.getLastName();

        return fullName.compareTo(fullNameO2);
    }
}
