package org.siit.homework.week7.repository;

import org.siit.homework.week7.enums.Gender;
import org.siit.homework.week7.model.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository {

    void addStudent(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String id);
    void deleteStudent(String id);

    List<Student> retrieveStudentsWithAge(int age);
    List<Student> listStudentsByLastName();
    List<Student> listStudentsByBirthDate();
}
