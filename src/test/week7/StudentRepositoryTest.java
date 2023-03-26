package week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListStudentException;
import org.siit.homework.week7.exception.RetrieveException;
import org.siit.homework.week7.student.Gender;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StudentRepositoryTest {
    @Test
    public void testAddValidStudentWithExceptionOnIt() throws RetrieveException {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Doe", LocalDate.of(1995, 5, 21), Gender.MALE, "1");

        try {
            repository.add(student);
        } catch (Exception e) {
            Assertions.fail("An unexpected exception occurred: " + e.getMessage());
        }

        List<Student> students = repository.retrieveAll();
        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(student, students.get(0));
    }

    @Test
    public void testAddInvalidStudentWithNoFirstName() {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("", "Doe", LocalDate.of(2025, 5, 21), Gender.MALE, "1");

        assertThrows(AddStudentException.class, () -> repository.add(student));
    }

    @Test
    void testRetrieveAllStudentsMethod() throws RetrieveException, AddStudentException {
        StudentRepository repo = new StudentRepository();
        Student student1 = new Student("John", "Doe", LocalDate.of(1995, 5, 20), Gender.MALE, "22");
        Student student2 = new Student("Doe", "Doe", LocalDate.of(1998, 8, 15), Gender.FEMALE, "23");
        repo.add(student1);
        repo.add(student2);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(student1);
        expectedList.add(student2);
        List<Student> actualList = repo.retrieveAll();
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void testRetrieveStudentsByAgeMethod() throws AddStudentException, RetrieveException {
        StudentRepository repo = new StudentRepository();
        Student student1 = new Student("John", "Doe", LocalDate.of(1995, 1, 20), Gender.MALE, "22");
        Student student2 = new Student("Doe", "Doe", LocalDate.of(1998, 8, 15), Gender.FEMALE, "21");
        repo.add(student1);
        repo.add(student2);
        List<Student> expectedList = new ArrayList<>();
        expectedList.add(student1);
        List<Student> actualList = repo.retrieveByAge(28);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void testDeleteStudentFromRepository() throws AddStudentException, RetrieveException, DeleteStudentException {
        StudentRepository repository = new StudentRepository();
        Student student = new Student("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1");
        repository.add(student);
        repository.delete(student.getId());
        Assertions.assertTrue(repository.retrieveAll().isEmpty());
    }
    @Test
    public void testListStudentsByLastName() throws AddStudentException, ListStudentException, RetrieveException {
        StudentRepository repository = new StudentRepository();
        repository.add(new Student("John", "Doe", LocalDate.of(2000, 1, 1), Gender.MALE, "1"));
        repository.add(new Student("Jane", "Doe", LocalDate.of(2002, 2, 2), Gender.FEMALE, "2"));
        repository.add(new Student("Alice", "Smith", LocalDate.of(1999, 3, 3), Gender.FEMALE, "3"));
        repository.add(new Student("Bob", "Smith", LocalDate.of(2001, 4, 4), Gender.MALE, "4"));

        List<Student> sortedStudents = repository.list("last name");
        String[] expectedLastNames = {"Doe", "Doe", "Smith", "Smith"};
        String[] actualLastNames = new String[sortedStudents.size()];
        for (int i = 0; i < actualLastNames.length; i++) {
            actualLastNames[i] = sortedStudents.get(i).getLastName();
        }
        Assertions.assertArrayEquals(expectedLastNames, actualLastNames);
    }


}

