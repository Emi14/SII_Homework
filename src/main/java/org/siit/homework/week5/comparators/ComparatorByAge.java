package org.siit.homework.week5.comparators;


import org.siit.homework.week5.person.Person;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int res;
        if (p1.getName().equals(p2.getName())) {
            res = 0;
        } else if (p1.getAge() == p2.getAge()) {
            res = p1.getName().compareTo(p2.getName());
        } else {
            res = p1.getAge() - p2.getAge();
        }
        return res;
    }

}
