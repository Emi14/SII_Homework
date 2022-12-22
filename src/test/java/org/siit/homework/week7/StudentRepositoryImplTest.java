package org.siit.homework.week7;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week7.exception.StudentCreationException;
import org.siit.homework.week7.exception.StudentException;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentRepositoryImplTest {

    StudentRepositoryImpl studentRepositoryImpl;
    List<Student> testStudentList;
    Set<Student> testStudentSet;
    Student testStudent;

    @BeforeEach
    void setUp() {
        studentRepositoryImpl = new StudentRepositoryImpl();
        testStudentList = new ArrayList<>();
        testStudentSet = new HashSet<>();
    }

//    @Test
//    public void testAddStudent_whenNameIsEmpty_ExceptionIsThrown() throws StudentCreationException {
//        testStudent = new Student("", "", 1990, "male", "123");
//        String expectedException = "First Name or Last Name should not be empty.";
//
//        assertEquals(expectedException, studentRepositoryImpl.addStudent("", "", 1990, "male", "123"));
//    }

    @Test
    public void testRetrieveAllStudentsOfAgeX_whenStudentsOfAgeXFound_returnTakesPlace() throws StudentCreationException, StudentException {
        studentRepositoryImpl.addStudent("Ion", "Popovici", 2000, "male", "123");
        List<Student> var = studentRepositoryImpl.retrieveAllStudentsOfAgeX(22);
        assertFalse(var.isEmpty());
    }

    @Test
    public void testListStudentByLastName_whenStudentSetIsNotEmpty_returnTakesPlace() throws StudentCreationException, StudentException {
        studentRepositoryImpl.addStudent("Ion", "Popovici", 2000, "male", "123");
        List<Student> var = studentRepositoryImpl.listStudentByLastName();
        assertFalse(var.isEmpty());
    }



}
