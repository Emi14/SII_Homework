package org.siit.homework.week7.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week7.enums.Gender;
import org.siit.homework.week7.model.Student;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryImplTest {
    private static StudentRepositoryImpl repository;

    @BeforeAll
    static void init() {
        repository = new StudentRepositoryImpl();
    }

    @BeforeEach
    void clearRepository() {
        repository.clear();
    }

    @Test
    void addStudent_shouldAddValidStudent() {
        repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1000101123456");
        List<Student> students = repository.listStudentsByLastName();
        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
    }

    @Test
    void addStudent_shouldThrowExceptionWhenInvalidId() {
        assertThrows(IllegalArgumentException.class, () ->
                repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1000131123456"));
    }

    @Test
    void deleteStudent_shouldDeleteExistingStudent() {
        repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1000101123456");
        repository.deleteStudent("1000101123456");
        List<Student> students = repository.listStudentsByLastName();
        assertEquals(0, students.size());
    }

    @Test
    void deleteStudent_shouldThrowExceptionWhenIdIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> repository.deleteStudent(""));
    }

    @Test
    void deleteStudent_shouldThrowExceptionWhenStudentDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> repository.deleteStudent("1000101123456"));
    }

    @Test
    void retrieveStudentsWithAge_shouldReturnStudentsWithAge() {
        repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1000101123456");
        repository.addStudent("Jane", "Doe", LocalDate.of(2000, 2, 2), Gender.FEMALE, "2000202123456");
        List<Student> students = repository.retrieveStudentsWithAge(23);
        assertEquals(2, students.size());
    }

    @Test
    void listStudentsByLastName_shouldReturnStudentsOrderedByLastName() {
        repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1000101123456");
        repository.addStudent("Jane", "Doe", LocalDate.of(2000, 2, 2), Gender.FEMALE, "2000202123456");
        List<Student> students = repository.listStudentsByLastName();
        assertEquals(2, students.size());
        assertEquals("Jane", students.get(0).getFirstName());
        assertEquals("Doe", students.get(0).getLastName());
        assertEquals("John", students.get(1).getFirstName());
        assertEquals("Doe", students.get(1).getLastName());
    }
}