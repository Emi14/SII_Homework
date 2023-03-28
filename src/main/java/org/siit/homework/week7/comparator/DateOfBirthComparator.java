package org.siit.homework.week7.comparator;

import org.siit.homework.week7.student.Student;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Student> {


    @Override
    public int compare(Student s1, Student s2) {
        return s1.getDateOfBirth().compareTo(s2.getDateOfBirth());
    }
}
