package org.siit.homework.week5.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hired implements Person {

    String name;
    int age;
    List<Hobby> hobbyList;
    int salary;

    public Hired(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;

        this.hobbyList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void addHobby(Hobby hobby) {
        this.hobbyList.add(hobby);
    }

    @Override
    public List<Hobby> returnHobby() {
        return this.hobbyList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hired)) return false;
        Hired hired = (Hired) o;
        return name.equals(hired.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
