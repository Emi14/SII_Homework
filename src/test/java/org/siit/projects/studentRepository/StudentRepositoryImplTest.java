package org.siit.projects.studentRepository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.projects.studentRepository.exception.StudentCreationException;
import org.siit.projects.studentRepository.exception.StudentException;
import org.siit.projects.studentRepository.student.Student;
import org.siit.projects.studentRepository.student.StudentRepositoryImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentRepositoryImplTest {

    StudentRepositoryImpl studentRepositoryImpl;
    List<Student> testStudentList;
    Set<Student> testStudentSet;

    @BeforeEach
    void setUp() {
        studentRepositoryImpl = new StudentRepositoryImpl();
        testStudentList = new ArrayList<>();
        testStudentSet = new HashSet<>();
    }

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
