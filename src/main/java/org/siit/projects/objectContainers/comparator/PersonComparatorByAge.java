package org.siit.projects.objectContainers.comparator;

import org.siit.projects.objectContainers.model.Person;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person person, Person otherPerson) {
        return person.getAge() - otherPerson.getAge();
    }
}
