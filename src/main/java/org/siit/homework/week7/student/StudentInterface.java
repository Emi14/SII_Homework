package org.siit.homework.week7.student;

import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListStudentException;
import org.siit.homework.week7.exception.RetrieveException;

import java.util.List;
import java.util.NoSuchElementException;

public interface StudentInterface {
    void add(Student student) throws AddStudentException, RetrieveException;
    void delete(String id) throws DeleteStudentException;
    List<Student> retrieveAll() throws RetrieveException;
    List<Student> retrieveByAge(int age) throws RetrieveException;
    List<Student> list(String orderBy) throws ListStudentException;
}
