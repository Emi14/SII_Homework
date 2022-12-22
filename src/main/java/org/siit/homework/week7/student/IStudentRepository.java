package org.siit.homework.week7.student;

import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.StudentCreationException;
import org.siit.homework.week7.exception.StudentException;


import java.util.List;

public interface IStudentRepository {

    void addStudent(String firstName, String lastName, int birthDate, String gender, String cnp) throws StudentCreationException;
    void deleteStudent(String cnp) throws DeleteStudentException, StudentException;
    List<Student> retrieveAllStudentsOfAgeX(int studentAgeX) throws StudentException;
    List<Student> listStudentByLastName() throws StudentException;
    List<Student> listStudentByBirthDate() throws StudentException;
}

