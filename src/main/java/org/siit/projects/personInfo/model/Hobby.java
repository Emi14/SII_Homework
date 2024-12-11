package org.siit.projects.personInfo.model;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    String nameOfHobby;
    int frequency;
    List<Address> addresses;

    public Hobby(String nameOfHobby, int frequency) {
        this.nameOfHobby = nameOfHobby;
        this.frequency = frequency;
        addresses = new ArrayList<>();
    }

    public void setAddresses(Address address) {
        addresses.add(address);
    }

    @Override
    public String toString() {
        return "\nHobby{" +
                "nameOfHobby='" + nameOfHobby + '\'' +
                ", frequency=" + frequency +
                ", addresses=" + addresses +
                '}';
    }
}
