package org.siit.homework.week5.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Person {

    String name;
    int age;
    List<Hobby> hobbyList;
    String university;

    public Student(String name, int age, String university) {
        this.name = name;
        this.age = age;
        this.university = university;

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
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
