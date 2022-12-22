package org.siit.homework.week7.comparator;
import org.siit.homework.week7.student.Student;
import java.util.Comparator;

public class StudentComparatorByLastName implements Comparator<Student> {

    @Override
    public int compare(Student student, Student otherStudent) {
        return student.getLastName().compareToIgnoreCase(otherStudent.getLastName());
    }
}
