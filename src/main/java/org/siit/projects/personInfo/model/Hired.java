package org.siit.projects.personInfo.model;

public class Hired extends Person{

    int salary;

    public Hired(String name, int age, int salary) {
        super(name, age);
        this.salary = salary;
    }
}
