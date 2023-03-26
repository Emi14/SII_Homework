package org.siit.homework.week7.comparator;

import org.siit.homework.week7.algorithm.Algorithm;
import org.siit.homework.week7.model.Student;

import java.util.Comparator;

public class SortByBirthDate implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        Algorithm algorithm = new Algorithm();
        return algorithm.calculateAge(s1.getBirthDate(), s2.getBirthDate());
    }
}
