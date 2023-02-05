package org.siit.homework.week5;

import java.util.List;

public class Hobby {
    private String hobbyName;
    private int frequency;
    private List<String> countries;

    public Hobby(String hobbyName, int frequency, List<String> countries) {
        this.hobbyName = hobbyName;
        this.frequency = frequency;
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyName='" + hobbyName + '\'' +
                ", frequency=" + frequency +
                ", countries=" + countries +
                '}';
    }
}

