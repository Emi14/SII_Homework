package org.siit.homework.week5.service;

import org.siit.homework.week5.comparator.PersonComparatorByAge;
import org.siit.homework.week5.comparator.PersonComparatorByName;
import org.siit.homework.week5.model.Address;
import org.siit.homework.week5.model.Hobby;
import org.siit.homework.week5.model.Person;

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
