package org.siit.projects.studentRepository.student;

import org.siit.projects.studentRepository.exception.DeleteStudentException;
import org.siit.projects.studentRepository.exception.StudentCreationException;
import org.siit.projects.studentRepository.exception.StudentException;

import java.util.List;

public interface IStudentRepository {

    void addStudent(String firstName, String lastName, int birthDate, String gender, String cnp) throws StudentCreationException;
    void deleteStudent(String cnp) throws DeleteStudentException, StudentException;
    List<Student> retrieveAllStudentsOfAgeX(int studentAgeX) throws StudentException;
    List<Student> listStudentByLastName() throws StudentException;
    List<Student> listStudentByBirthDate() throws StudentException;
}

