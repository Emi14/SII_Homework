package org.siit.homework.week9;

import java.util.Comparator;

public class PersonSurnameNameComparator implements Comparator<Person1> {
    @Override
       public int compare(Person1 p1, Person1 p2) {
        int cmp = p1.getSurname().compareTo(p2.getSurname());
        if (cmp != 0) {
            return cmp;
        }
        return p1.getName().compareTo(p2.getName());
    }
}