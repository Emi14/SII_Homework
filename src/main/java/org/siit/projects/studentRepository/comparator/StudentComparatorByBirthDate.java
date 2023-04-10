package org.siit.projects.studentRepository.comparator;


import org.siit.projects.studentRepository.student.Student;
import java.util.Comparator;

public class StudentComparatorByBirthDate implements Comparator<Student> {

    @Override
    public int compare(Student student, Student otherStudent) {
        return student.getBirthDate() - otherStudent.getBirthDate();
    }
}
