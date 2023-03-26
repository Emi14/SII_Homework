package org.siit.homework.hw6Tema7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.hw6Tema7.exception.AgeException;
import org.siit.homework.hw6Tema7.exception.CnpException;
import org.siit.homework.hw6Tema7.exception.OrderException;
import org.siit.homework.hw6Tema7.exception.StudentNotFoundException;
import org.siit.homework.hw6Tema7.model.Student;
import org.siit.homework.hw6Tema7.repository.StudentRepository;
import org.siit.homework.hw6Tema7.utils.OrderBy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {
    Logger logger = Logger.getLogger(StudentRepositoryTest.class.getName());
    StudentRepository studentRepository = new StudentRepository();

    @BeforeEach
    void setup() {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setDateOfBirth(1999);
        s1.setCnp(1990314425897L);
        s1.setGender("m");
        s1.setLastName("Nistor");
        s1.setFirstName("Sebastian");

        s2.setDateOfBirth(2004);
        s2.setCnp(5041004427173L);
        s2.setGender("M");
        s2.setLastName("Munteanu");
        s2.setFirstName("Igor");

        s3.setDateOfBirth(2003);
        s3.setCnp(6030819428520L);
        s3.setGender("F");
        s3.setLastName("Manolache");
        s3.setFirstName("Daria");

        studentRepository.add(s1);
        studentRepository.add(s2);
        studentRepository.add(s3);
    }

    @Test
    void shouldDeleteStudent() {
//        given
        int listSize = studentRepository.getAll().size();
//        when
        try {
            studentRepository.delete(1990314425897L);
        } catch (CnpException e) {
           logger.log(Level.SEVERE, e.getMessage(), e.getCause());
        }
//        then
        assertEquals(studentRepository.getAll().size(), listSize - 1);
    }

    @Test
    void shouldThrowCnpException() {
//        given
        Long cnp = null;
//        when/then
        assertThrows(CnpException.class, () -> studentRepository.delete(cnp));
    }

    @Test
    void shouldThrowStudentNotFoundException() {
//        given
        Long cnp = 2960220425641L;
//        when/then
        assertThrows(StudentNotFoundException.class, () -> studentRepository.delete(cnp));
    }

    @Test
    void shouldAddStudent() {
//        given
        int listSize = studentRepository.getAll().size();
        Student s4 = new Student();
        s4.setFirstName("Oana");
        s4.setLastName("Florescu");
        s4.setGender("f");
        s4.setCnp(2940426429769L);
        s4.setDateOfBirth(1994);
//        when
        studentRepository.add(s4);
//        then
        assertEquals(listSize + 1, studentRepository.getAll().size());
        assertEquals("Florescu", studentRepository.getByCnp(2940426429769L).getLastName());
        assertEquals("Oana", studentRepository.getByCnp(2940426429769L).getFirstName());
    }

    @Test
    void shouldReturnListOfStudents() {
//        given/when
        List<Student> studentList = studentRepository.getAll();
//        then
        assertNotNull(studentList);
        assertEquals(3, studentList.size());
    }

    @Test
    void shouldOrderStudentsByName() {
//        given
        OrderBy orderBy = OrderBy.LAST_NAME;
//        when
        List<Student> studentList = studentRepository.list(orderBy);
//        then
        assertTrue(studentList.get(0).getLastName().compareTo(studentList.get(1).getLastName()) < 0);
    }

    @Test
    void shouldThrowOrderException() {
//        given
        OrderBy orderBy = null;
//        when/then
        assertThrows(OrderException.class, () -> studentRepository.list(orderBy));
    }

    @Test
    void shouldListStudentsByAge() {
//      given
        Integer age = 20;
//      when
        List<Student> studentList = studentRepository.retrieveAllByAge(age);
//      then
        assertEquals(1, studentList.size());
    }

    @Test
    void shouldThrowAgeException() {
//        given
        Integer age = -20;
//        when/then
        assertThrows(AgeException.class, () -> studentRepository.retrieveAllByAge(age));
    }
}
