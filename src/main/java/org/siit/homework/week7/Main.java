package org.siit.homework.week7;

import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.RetrieveException;
import org.siit.homework.week7.student.Gender;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.StudentInterface;
import org.siit.homework.week7.student.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws RetrieveException, DeleteStudentException {
        LOGGER.info("This is the main class for week 7 homework");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Student student = new Student("Georgiana", "Arcus", LocalDate.parse("23/04/1985", formatter), Gender.FEMALE, "1");
        Student student1 = new Student("Marius", "Arcus", LocalDate.parse("14/03/1986", formatter), Gender.MALE, "2");
        Student student2 = new Student("Elena", "Tanasa", LocalDate.parse("16/02/1960", formatter), Gender.FEMALE, "3");
        Student student3 = new Student("Cristian", "Zagan", LocalDate.parse("17/04/1985", formatter), Gender.MALE, "4");
        StudentRepository studentRepository = new StudentRepository();

        try {
            studentRepository.add(student);
            studentRepository.add(student1);
            studentRepository.add(student2);
            studentRepository.add(student3);
        } catch (AddStudentException e) {
            LOGGER.severe("An error occurred while adding a student: " + e.getMessage());
        } catch (RetrieveException e) {
            LOGGER.severe("An error occurred while retrieving students: " + e.getMessage());
        }

        LOGGER.info("Printing all students:");
        studentRepository.retrieveAll().forEach(s -> LOGGER.info(s.toString()));

        LOGGER.info("Retrieving students with age 24:");
        studentRepository.retrieveByAge(24).forEach(s -> LOGGER.info(s.toString()));

        try {
            LOGGER.info("Deleting student with id 4");
            studentRepository.delete("4");
        } catch (DeleteStudentException e) {
            LOGGER.severe("An error occurred while deleting a student: " + e.getMessage());
        }

        LOGGER.info("Printing all students after deletion:");
        studentRepository.retrieveAll().forEach(s -> LOGGER.info(s.toString()));
    }
}