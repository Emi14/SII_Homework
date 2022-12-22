package org.siit.homework.week7;

import org.siit.homework.week7.model.Student;
import org.siit.homework.week7.repository.StudentRepository;
import org.siit.homework.week7.repository.StudentRepositoryImplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 7 homework");
        System.out.println();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Student student = new Student("1234", "Iulia", "Stoica", LocalDate.parse("19/09/1999", formatter), "F");
        Student student1 = new Student("1235", "Alexandru", "Popescu", LocalDate.parse("05/08/1998", formatter), "M");
        Student student2 = new Student("1236", "Valentin", "Radu", LocalDate.parse("05/08/1998", formatter), "M");
        Student student3 = new Student("1237", "Lucia", "Prodi", LocalDate.parse("19/09/1999", formatter), "F");
        StudentRepository studentRepository = new StudentRepositoryImplementation();
        studentRepository.addStudent(student);
        studentRepository.addStudent(student1);
        studentRepository.addStudent(student2);
        studentRepository.addStudent(student3);
        System.out.println();
        studentRepository.getAllStudents().forEach(System.out::println);
        System.out.println();
        studentRepository.retrieveStudentByAge("24").forEach(System.out::println);
        studentRepository.deleteStudent("1236");
        System.out.println();
        studentRepository.getAllStudents().forEach(System.out::println);
    }
}