package org.siit.homework.week5.comparators;


import org.siit.homework.week5.person.Person;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

}
