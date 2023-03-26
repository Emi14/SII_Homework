package org.siit.homework.week5.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Unemployed implements Person {

    String name;
    int age;
    List<Hobby> hobbyList;

    public Unemployed(String name, int age) {
        this.name = name;
        this.age = age;

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
    public String toString() {
        return "Unemployed{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Unemployed)) return false;
        Unemployed that = (Unemployed) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
