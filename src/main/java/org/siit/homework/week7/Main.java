package org.siit.homework.week7;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
//    Create a Student repository which supports:
//            - add student - exceptions when validating conditions mentioned bellow
//     - delete student (by ID - identifier) - exceptions: ID is empty, student does not exist
//     - retrieve all students with age X (for each student the age must be calculated, not stored in a field) - exceptions:
//     age is not a number, age is negative
//     - list students and order by Last Name or Birth Date - exceptions: any input is empty
//     - these methods must validate inputs and throw exceptions if necessary
//
//     - for each Student the following information needs to be collected:
//          First Name
//          Last Name
//          Date of Birth
//          Gender
//          ID (CNP)
//     - the following validations are expected:
//          date of birth between 1900 and current year - 18
//          first name and last name should not be empty
//          gender should be male or female (or M and F), upper / lower case should both be accepted
//     - for all the validations, the corresponding exception(s) should be thrown when a Student is created
//    with data which breaks the validation constraint
//     - the testing application can demonstrate the implementation of the above requirements without
//    requiring a special menu for creating the students or for choosing the operation
//     - create several test methods which perform separately a given scenario
//     - additionally, you should use Logger for tracing and error handling
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Logger logger = Logger.getLogger(Main.class.getName());

        // add students
        System.out.println("\n----------- Trying to add a student with a wrong birth year: -----------");
        try {
            studentRepository.addStudent(new Student("Alexandru", "Pop", LocalDate.of(-1998, 4, 2), "M", 2041998));
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Exception occurred during add operation", e);
        }
        studentRepository.addStudent(new Student("Ion","Stanca", LocalDate.of(1997,7,4),"M",4071997));
        studentRepository.addStudent(new Student("Maria","Ilies", LocalDate.of(1999,10,25),"f",25101999));
        studentRepository.addStudent(new Student("Marin","Rus", LocalDate.of(1999,11,22),"f",22111999));

        // list all students
        studentRepository.listStudents();

        // list all students ordered by last name
        studentRepository.listStudentsOrderByLastName();

        // retrieve students by age
        List<Student> studentsByAge = studentRepository.retrieveAllByAge(23);
        System.out.println(studentsByAge);

        // remove student by cnp
        studentRepository.deleteByCNP(4071997);
        studentRepository.listStudents();

        // remove non-existent student by cnp
        System.out.println("----------- Trying to remove a student with a wrong CNP: -----------");
        try {
            studentRepository.deleteByCNP(40719977);
        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, "Exception occurred during delete operation", e);
        }

        ////// TESTS AVAILABLE. PLEASE CHECK HERE: src/test/java/org/siit/homework/week7 //////

    }

}