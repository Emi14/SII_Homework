package org.siit.projects.objectContainers.comparator;

import org.siit.projects.objectContainers.model.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person, Person otherPerson) {
        return person.getName().compareTo(otherPerson.getName());
    }
}
