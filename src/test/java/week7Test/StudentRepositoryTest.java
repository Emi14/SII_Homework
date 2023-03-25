package week7Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.siit.homework.week7.exeptions.EmptyVariableException;
import org.siit.homework.week7.exeptions.InvalidInputFormatException;
import org.siit.homework.week7.exeptions.OutOfMemoryException;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.studentRepository.StudentRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.DateTimeException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Set<Student> studentSet = new HashSet<>();
    private final Student firstTestStudent = new Student(
            "Nicu", "Dandu", "1995-10-01", "M", "1951001345676");
    private final Student secondTestStudent = new Student(
            "Clara", "Popescu", "1980-04-18", "F", "123456");

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testAddStudent_whenFirstNameIsEmpty_thenExceptionThrown() {
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.addStudent(studentSet, "",
                        "Dandu", "1995-10-01", "M", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenLastNameIsEmpty_thenExceptionThrown() {
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.addStudent(studentSet, "Nicu",
                        "", "1996-10-01", "M", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenBirthDateIsSmallerThan1900_thenExceptionThrown() {
        assertThrows(OutOfMemoryException.class,
                () -> StudentRepository.addStudent(studentSet, "Nicu",
                        "Dandu", "1870-12-25", "M", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenBirthDateIsGreaterThanCurrentYear_thenExceptionThrown() {
        assertThrows(OutOfMemoryException.class,
                () -> StudentRepository.addStudent(studentSet, "Nicu",
                        "Dandu", "2024-12-25", "M", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenBirthDateDoNotRespectFormat_thenExceptionThrown() {
        assertThrows(DateTimeException.class,
                () -> StudentRepository.addStudent(studentSet, "Nicu",
                        "Dandu", "1995-1001", "M", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenGenderDoNotRespectFormat_thenExceptionThrown() {
        assertThrows(InvalidInputFormatException.class,
                () -> StudentRepository.addStudent(studentSet, "Nicu",
                        "Dandu", "1995-10-01", "G", "1951001345676"));

    }

    @Test
    public void testAddStudent_whenAllParametersAreCorrect_thenStudentAdded() throws Exception {
        StudentRepository.addStudent(studentSet, "Nicu",
                "Dandu", "1995-10-01", "M", "1951001345676");
        assertFalse(studentSet.isEmpty());
    }

    @Test
    public void testDeleteStudent_whenSetIsEmpty_thenExceptionThrown() {
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.deleteStudent(studentSet, "123456"));
    }

    @Test
    public void testDeleteStudent_whenStudentIsNotInTheSet_thenExceptionThrown() {
        studentSet.add(firstTestStudent);
        assertThrows(EmptyVariableException.class,
                () -> StudentRepository.deleteStudent(studentSet, "123456"));
    }

    @Test
    public void testDeleteStudent_whenStudentIsInSet_thenShowSuccessMessage()
            throws EmptyVariableException {
        studentSet.add(firstTestStudent);
        StudentRepository.deleteStudent(studentSet, "1951001345676");
        assertEquals("The student with CNP: 1951001345676 has been removed", outContent.toString().trim());
    }

    @Test
    public void testRetrieveStudentsOfAge_whenInputIsNotNumber_thenExceptionThrown() {
        assertThrows(NumberFormatException.class,
                () -> StudentRepository.retrieveStudentsOfAge(studentSet, "abcd"));
    }

    @Test
    public void testRetrieveStudentsOfAge_whenInputIsNegative_thenExceptionThrown() {
        assertThrows(InvalidInputFormatException.class,
                () -> StudentRepository.retrieveStudentsOfAge(studentSet, "-1"));
    }

    @Test
    public void testRetrieveStudentsOfAge_whenSetDonNotHaveStudentsOfThatAge_thenNothingIsPrinted()
            throws InvalidInputFormatException {
        StudentRepository.retrieveStudentsOfAge(studentSet, "25");
        assertEquals("", outContent.toString());
    }

    @Test
    public void testListSortedStudents_whenInputIsInvalid_thenExceptionThrown() {
        assertThrows(InvalidInputFormatException.class,
                () -> StudentRepository.listSortedStudents(studentSet, "3"));
    }

    @Test
    public void testListSortedStudents_whenInputIs1_thenPrintStudentsSortedByLastName()
            throws InvalidInputFormatException {
        studentSet.add(firstTestStudent);
        studentSet.add(secondTestStudent);
        StudentRepository.listSortedStudents(studentSet, "1");
        String expectedResult = firstTestStudent + "\n" + secondTestStudent;
        String actualResult = outContent.toString();
        Scanner scanner1 = new Scanner(expectedResult);
        Scanner scanner2 = new Scanner(actualResult);
        int firstLine = scanner1.nextLine().compareTo(scanner2.nextLine());
        int secondLine = scanner1.nextLine().compareTo(scanner2.nextLine());
        scanner1.close();
        scanner2.close();
        assertEquals(0, firstLine + secondLine);
    }

    @Test
    public void testListSortedStudents_whenInputIs2_thenPrintStudentsSortedByLastName()
            throws InvalidInputFormatException {
        studentSet.add(firstTestStudent);
        studentSet.add(secondTestStudent);
        StudentRepository.listSortedStudents(studentSet, "2");
        String expectedResult = secondTestStudent + "\n" + firstTestStudent;
        String actualResult = outContent.toString();
        Scanner scanner1 = new Scanner(expectedResult);
        Scanner scanner2 = new Scanner(actualResult);
        int firstLine = scanner1.nextLine().compareTo(scanner2.nextLine());
        int secondLine = scanner1.nextLine().compareTo(scanner2.nextLine());
        scanner1.close();
        scanner2.close();
        assertEquals(0, firstLine + secondLine);
    }
}
