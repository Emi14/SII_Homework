package org.siit.projects.personInfo.service;

import org.siit.projects.personInfo.comparator.PersonComparatorByAge;
import org.siit.projects.personInfo.comparator.PersonComparatorByName;
import org.siit.projects.personInfo.model.Hobby;
import org.siit.projects.personInfo.model.Person;

import java.util.*;

public class ServiceImpl implements IService{

    Set<Person> people;
    Map<Person, List<Hobby>> personInfoStored;

    public ServiceImpl() {
        people = new TreeSet<>(new PersonComparatorByName().thenComparing(new PersonComparatorByAge()));
        personInfoStored = new HashMap<>();
    }

    @Override
    public void addPerson(Person person) {
        people.add(person);
    }

    @Override
    public void iteratePersons() {
        for(Person person: people){
            System.out.println(person.getName() + " is " +  person.getAge() + " years old.");
        }
    }

    @Override
    public void storePersonAndHobbies(Person person, List<Hobby> hobbies) {
        personInfoStored.put(person, hobbies);
    }
    @Override
    public Map<Person, List<Hobby>> getPersonInfoStored() {
        return personInfoStored;
    }
}
