package org.siit.homework.week7.repository;

import org.siit.homework.week7.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents();
    void addStudent(Student student);
    void deleteStudent(String ID);
    List<Student> retrieveStudentByAge(String age);
}
