package org.siit.homework.week7;

import org.siit.homework.week7.enums.Gender;
import org.siit.homework.week7.impl.StudentRepositoryImpl;
import org.siit.homework.week7.model.Student;
import org.siit.homework.week7.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 7 homework");

        StudentRepository repo = new StudentRepositoryImpl();

        try {
            repo.addStudent("John", "Doe", LocalDate.of(1995, 5, 1), Gender.MALE, "1234567890123");
            repo.addStudent("Jane", "Doe", LocalDate.of(1998, 8, 23), Gender.FEMALE, "2234567890123");
            repo.addStudent("Bob", "Smith", LocalDate.of(2000, 1, 15), Gender.MALE, "3234567890123");
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to add students: " + e.getMessage());
        }

        System.out.println("Students with age 23:");
        try {
            List<Student> students = repo.retrieveStudentsWithAge(23);
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to retrieve students: " + e.getMessage());
        }

        System.out.println("All students ordered by last name:");
        try {
            List<Student> students = repo.listStudentsByLastName();
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to list students: " + e.getMessage());
        }

        try {
            repo.deleteStudent("2234567890123");
        } catch (IllegalArgumentException e) {
            System.err.println("Failed to delete student: " + e.getMessage());
        }
    }
}