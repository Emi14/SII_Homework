package org.siit.projects.objectContainers.service;

import org.siit.projects.objectContainers.model.Hobby;
import org.siit.projects.objectContainers.model.Person;

import java.util.List;
import java.util.Map;

public interface IService {

    void addPerson(Person person);
    void iteratePersons();
    void storePersonAndHobbies(Person person, List<Hobby> hobbies);
    Map<Person, List<Hobby>> getPersonInfoStored();
}
