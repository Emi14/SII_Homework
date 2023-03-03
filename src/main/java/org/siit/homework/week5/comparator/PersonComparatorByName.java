package org.siit.homework.week5.comparator;

import org.siit.homework.week5.model.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person person, Person otherPerson) {
        return person.getName().compareTo(otherPerson.getName());
    }
}
