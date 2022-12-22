package org.siit.homework.week7.comparator;

import org.siit.homework.week7.student.IStudent;
import org.siit.homework.week7.student.Student;

import java.util.Comparator;

public class ComparatorByBirthDate implements Comparator<Student> {


    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
