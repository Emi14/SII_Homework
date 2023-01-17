package org.siit.homework.week5;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person> {

    @Override
    public int compare (Person person, Person otherPerson) {
        return person.getAge().compareTo(otherPerson.getAge());
    }

}
