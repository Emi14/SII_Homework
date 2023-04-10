package org.siit.projects.studentRepository.comparator;
import org.siit.projects.studentRepository.student.Student;
import java.util.Comparator;

public class StudentComparatorByLastName implements Comparator<Student> {

    @Override
    public int compare(Student student, Student otherStudent) {
        return student.getLastName().compareToIgnoreCase(otherStudent.getLastName());
    }
}
