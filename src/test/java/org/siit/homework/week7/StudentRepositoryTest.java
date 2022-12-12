package org.siit.homework.week7;

import org.junit.jupiter.api.Test;
import org.siit.homework.week7.exception.EmptyVariableException;
import org.siit.homework.week7.exception.InvalidInputFormatException;
import org.siit.homework.week7.exception.OutOfBoundsException;


import java.time.DateTimeException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


class StudentRepositoryTest {

    @Test
    public void testAddStudent_whenFirstNameIsEmpty_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.addStudent(studentSet, "",
                        "Cirebea", "1996-11-25", "M", "123456"));

    }

    @Test
    public void testAddStudent_whenLastNameIsEmpty_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.addStudent(studentSet, "Felix",
                        "", "1996-11-25", "M", "123456"));

    }

    @Test
    public void testAddStudent_whenBirthDateIsSmallerThan1900_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(OutOfBoundsException.class,
                () -> StudentRepository.addStudent(studentSet, "Felix",
                        "Cirebea", "1850-11-25", "M", "123456"));

    }

    @Test
    public void testAddStudent_whenBirthDateIsGreaterThanCurrentYear_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(OutOfBoundsException.class,
                () -> StudentRepository.addStudent(studentSet, "Felix",
                        "Cirebea", "2023-11-25", "M", "123456"));

    }

    @Test
    public void testAddStudent_whenBirthDateDoNotRespectFormat_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(DateTimeException.class,
                () -> StudentRepository.addStudent(studentSet, "Felix",
                        "Cirebea", "1996-25-11", "M", "123456"));

    }

    @Test
    public void testAddStudent_whenGenderDoNotRespectFormat_thenExceptionThrown() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        assertThrows(InvalidInputFormatException.class,
                () -> StudentRepository.addStudent(studentSet, "Felix",
                        "Cirebea", "1996-11-25", "D", "123456"));

    }

    @Test
    public void testAddStudent_whenAllParametersAreCorrect_thenStudentAdded() throws Exception {
        Set<Student> studentSet = new HashSet<>();
        StudentRepository.addStudent(studentSet, "Felix",
                "Cirebea", "1996-11-25", "M", "123456");
        assertFalse(studentSet.isEmpty());

    }

}