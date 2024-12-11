package org.siit.projects.personInfo.model;

public class Address {

    String country;
    String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "\n\tAddress{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
