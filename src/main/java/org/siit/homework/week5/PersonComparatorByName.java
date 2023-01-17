package org.siit.homework.week5;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare (Person person, Person otherPerson) {
        return person.getName().compareTo(otherPerson.getName());
    }

}
