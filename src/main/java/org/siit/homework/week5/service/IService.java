package org.siit.homework.week5.service;

import org.siit.homework.week5.model.Hobby;
import org.siit.homework.week5.model.Person;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IService {

    void addPerson(Person person);
    void iteratePersons();
    void storePersonAndHobbies(Person person, List<Hobby> hobbies);
    Map<Person, List<Hobby>> getPersonInfoStored();
}
