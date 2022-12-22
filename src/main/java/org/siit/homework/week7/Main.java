package org.siit.homework.week7;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();


        try {
            // Add some students
            repository.addStudent(new Student("Alice", "Smith", LocalDate.of(2000, 1, 1), "f", "123456789"));
            repository.addStudent(new Student("Bob", "Johnson", LocalDate.of(1999, 2, 28), "m", "987654321"));
            repository.addStudent(new Student("Charlie", "Williams", LocalDate.of(1998, 3, 31), "m", "111511111"));
            repository.addStudent(new Student("Daisy", "Jones", LocalDate.of(1997, 4, 30), "f", "222982222"));

            // Delete a student
            repository.deleteStudent("987654321");

            // Retrieve students by age
            List<Student> students20 = repository.retrieveStudentsByAge(20);
            for (Student student : students20) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }

            // List students by last name
            List<Student> studentsByLastName = repository.listStudents("last name");
            for (Student student : studentsByLastName) {
                System.out.println(student.getLastName() + ", " + student.getFirstName());
            }
        } catch (Exception e) {

        }
    }
}

