package org.siit.homework.week9;

import javafx.scene.input.DataFormat;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Person
{
    String latName;
    String firstName;
    LocalDate birthDate;

    public Person(String firstName, String latName, LocalDate birthDate) {
        this.latName = latName;
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    public String getLatName() {
        return latName;
    }

    public String getFirstName() {
        return firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "latName='" + firstName + '\'' +
                ", firstName='" + latName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
