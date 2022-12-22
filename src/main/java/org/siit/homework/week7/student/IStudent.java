package org.siit.homework.week7.student;

import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListException;
import org.siit.homework.week7.exception.RetrieveException;

import java.util.Set;

public interface IStudent
{
    Student addStudent(String firstName, String lastName, String dateOfBirth, String gender, String id) throws AddStudentException;
    void deleteStudent(String id) throws DeleteStudentException;
    String retrieveAllByAge(int age) throws RetrieveException;
    String list(String condition) throws ListException;

}
