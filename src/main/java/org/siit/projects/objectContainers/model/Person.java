package org.siit.projects.objectContainers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person {
    String name;
    int age;
    List<Hobby> hobbies;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        hobbies = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addHobby(Hobby hobby){
        hobbies.add(hobby);
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }
}
