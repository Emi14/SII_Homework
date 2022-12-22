package org.siit.homework.week7.comparator;

import org.siit.homework.week7.student.Student;

import java.util.Comparator;

public class StudentComparatorByBirthDate implements Comparator<Student> {


    @Override
    public int compare(Student student, Student otherStudent) {
        return student.getBirthDate() - otherStudent.getBirthDate();
    }
}
