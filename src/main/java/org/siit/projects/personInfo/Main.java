package org.siit.projects.personInfo;

import org.siit.projects.personInfo.model.*;
import org.siit.projects.personInfo.service.IService;
import org.siit.projects.personInfo.service.ServiceImpl;

public class Main {

    public static final IService serviceImpl = new ServiceImpl();
    public static void main(String[] args) {

        Person student = new Student("Ionel", 21, "ASE");
        Person employee = new Hired("Cornel", 37, 10500);
        Person unemployed = new Unemployed("Cornel", 48);

        serviceImpl.addPerson(student);
        serviceImpl.addPerson(employee);
        serviceImpl.addPerson(unemployed);

        serviceImpl.iteratePersons();

        Hobby hobbyOneForStudent = new Hobby("bowling", 4);
        hobbyOneForStudent.setAddresses(new Address("Romania", "Bucharest"));
        hobbyOneForStudent.setAddresses(new Address("Moldova", "Chisinau"));
        student.addHobby(hobbyOneForStudent);

        Hobby hobbyTwoForStudent = new Hobby("dancing", 2);
        hobbyTwoForStudent.setAddresses(new Address("Spain", "Malaga"));
        hobbyTwoForStudent.setAddresses(new Address("UK", "London"));
        student.addHobby(hobbyTwoForStudent);

        serviceImpl.storePersonAndHobbies(student, student.getHobbies());

        Hobby hobbyOneForEmployee = new Hobby("reading", 5);
        hobbyOneForEmployee.setAddresses(new Address("Romania", "Brasov"));
        hobbyOneForEmployee.setAddresses(new Address("Germany", "Hamburg"));
        employee.addHobby(hobbyOneForEmployee);

        Hobby hobbyTwoForEmployee = new Hobby("music", 1);
        hobbyTwoForEmployee.setAddresses(new Address("Romania", "Sighisoara"));
        hobbyTwoForEmployee.setAddresses(new Address("Iceland", "Reykjavik"));
        employee.addHobby(hobbyTwoForEmployee);

        serviceImpl.storePersonAndHobbies(employee, employee.getHobbies());

        Hobby hobbyOneForUnemployed = new Hobby("reading", 3);
        hobbyOneForUnemployed.setAddresses(new Address("Hungary", "Budapest"));
        hobbyOneForUnemployed.setAddresses(new Address("Belgium", "Bruges"));
        unemployed.addHobby(hobbyOneForUnemployed);

        Hobby hobbyTwoForUnemployed = new Hobby("watchingMovies", 3);
        hobbyTwoForUnemployed.setAddresses(new Address("Romania", "Ploiesti"));
        hobbyTwoForUnemployed.setAddresses(new Address("Bulgaria", "Sofia"));
        unemployed.addHobby(hobbyTwoForUnemployed);

        serviceImpl.storePersonAndHobbies(unemployed, unemployed.getHobbies());

        System.out.println(student);

//        System.out.println(serviceImpl.getPersonInfoStored());






    }
}
