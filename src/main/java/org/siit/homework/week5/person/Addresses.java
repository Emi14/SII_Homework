package org.siit.homework.week5.person;

public class Addresses {

    String street;
    int number;
    String city;
    String country;

    public Addresses(String street, int number, String city, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                ", country='" + country + '\'' +
                '}';
    }
}
