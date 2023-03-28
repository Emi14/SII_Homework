package org.siit.homework.week5.person;

import java.util.ArrayList;
import java.util.List;

public class Hobby {

    String name;
    int frequency;
    List<Addresses> addressesList;

    public Hobby(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;

        addressesList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "name='" + name + '\'' +
                ", countries where can be practiced=" + addressesList.toString() +
                '}';
    }

    public void addAddress(Addresses address) {
        this.addressesList.add(address);
    }

}
