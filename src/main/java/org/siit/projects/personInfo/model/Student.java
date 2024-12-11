package org.siit.projects.personInfo.model;

public class Student extends Person{

    String university;

    public Student(String name, int age, String university) {
        super(name, age);
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                " name= '" + name + '\'' +
                ", age= " + age +
                ", university= '" + university + '\'' +
                ", hobbies= " + hobbies +
                '}';
    }
}
