package org.siit.homework.week5;

import java.util.List;

public class Person {
    private String name;
    private Integer age;
//    private Hobby hobby;
    private List<Hobby> hobbyList;

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, List<Hobby> hobbyList) {
        this.name = name;
        this.hobbyList = hobbyList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbyList=" + hobbyList +
                '}';
    }
}
