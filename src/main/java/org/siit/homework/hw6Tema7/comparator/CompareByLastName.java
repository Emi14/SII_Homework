package org.siit.homework.hw6Tema7.comparator;

import org.siit.homework.hw6Tema7.model.Student;

import java.util.Comparator;

public class CompareByLastName implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
