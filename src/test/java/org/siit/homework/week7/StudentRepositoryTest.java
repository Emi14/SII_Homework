package org.siit.homework.week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class StudentRepositoryTest {

    @Test
    public void testAddValidStudent() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Ion","Stanca", LocalDate.of(1997,7,4),"M",4071997);
        studentRepository.addStudent(student);
        List<Student> studentList = studentRepository.getStudentList();

        Assertions.assertTrue(studentList.contains(student));

    }
    @Test
    public void testAddStudentWithInvalidDate() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Ion","Stanca", LocalDate.of(1897,7,4),"M",4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class,()->studentRepository.addStudent(student));
        Assertions.assertEquals("The date should be between 1900 and current year - 18.",thrownException.getMessage());

    }
    @Test
    public void testAddStudentWithEmptyFirstName() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("","Stanca", LocalDate.of(1997,7,4),"M",4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class,()->studentRepository.addStudent(student));
        Assertions.assertEquals("The first name should not be empty.",thrownException.getMessage());

    }

    @Test
    public void testAddStudentWithInvalidGender() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Ion","Stanca", LocalDate.of(1997,7,4),"L",4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class,()->studentRepository.addStudent(student));
        Assertions.assertEquals("The gender should be m, f, male or female.",thrownException.getMessage());

    }

    @Test
    public void testRetrieveAllByAge() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(new Student("Ion","Stanca", LocalDate.of(1997,7,4),"M",4071997));
        studentRepository.addStudent(new Student("Maria","Ilies", LocalDate.of(1999,10,25),"f",25101999));
        studentRepository.addStudent(new Student("Marin","Rus", LocalDate.of(1999,11,22),"f",22111999));
        List<Student> studentList = studentRepository.retrieveAllByAge(23);
        System.out.println(studentList);

        Assertions.assertEquals(2,studentList.size());

    }


}
