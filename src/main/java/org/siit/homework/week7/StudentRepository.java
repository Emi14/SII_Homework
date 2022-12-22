package org.siit.homework.week7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StudentRepository {
    private static final Logger LOGGER = Logger.getLogger(StudentRepository.class.getName());
    private List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) throws Exception {
        if (student.getFirstName().isEmpty()) {
            throw new Exception("First name cannot be empty");
        }
        if (student.getLastName().isEmpty()) {
            throw new Exception("Last name cannot be empty");
        }
        if (student.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) {
            throw new Exception("Date of birth must be before current year minus 18");
        }
        if (!student.getGender().equalsIgnoreCase("male") && !student.getGender().equalsIgnoreCase("female")) {
            throw new Exception("Gender must be male or female");
        }
        students.add(student);
    }

    public void deleteStudent(String id) throws Exception {
        if (id.isEmpty()) {
            throw new Exception("ID cannot be empty");
        }
        Student studentToDelete = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToDelete = student;
                break;
            }
        }
        if (studentToDelete == null) {
            throw new Exception("Student with ID " + id + " does not exist");
        }
        students.remove(studentToDelete);
    }

    public List<Student> retrieveStudentsByAge(int age) throws Exception {
        if (age < 0) {
            throw new Exception("Age must be a positive number");
        }
        List<Student> studentsByAge = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                studentsByAge.add(student);
            }
        }
        return studentsByAge;
    }

    public List<Student> listStudents(String orderBy) throws Exception {
        if (orderBy.isEmpty()) {
            throw new Exception("Order by parameter cannot be empty");
        }
        List<Student> sortedStudents = new ArrayList<>(students);
        if (orderBy.equalsIgnoreCase("last name")) {
            sortedStudents.sort((s1, s2) -> s1.getLastName().compareToIgnoreCase(s2.getLastName()));
        } else if (orderBy.equalsIgnoreCase("birth date")) {
            sortedStudents.sort((s1, s2) -> s1.getDateOfBirth().compareTo(s2.getDateOfBirth()));
        } else {
            throw new Exception("Invalid order by parameter: " + orderBy);
        }
        return sortedStudents;
    }
}

