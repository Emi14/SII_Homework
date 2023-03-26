package org.siit.homework.week7.impl;

import org.siit.homework.week7.model.Student;
import org.siit.homework.week7.enums.Gender;
import org.siit.homework.week7.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students;
    private static final Logger LOGGER = Logger.getLogger(StudentRepositoryImpl.class.getName());

    public StudentRepositoryImpl() {
        students = new ArrayList<>();
    }

    @Override
    public void addStudent(String firstName, String lastName, LocalDate dateOfBirth, Gender gender, String id) {
        validateFirstName(firstName);
        validateLastName(lastName);
        validateDateOfBirth(dateOfBirth);
        validateGender(gender);
        validateId(id);
        Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
        students.add(student);
    }

    @Override
    public void deleteStudent(String id) {
        validateId(id);
        boolean removed = students.removeIf(s -> s.getId().equals(id));
        if (!removed) {
            LOGGER.log(Level.SEVERE, "Student with ID " + id + " not found");
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }

    @Override
    public List<Student> retrieveStudentsWithAge(int age) {
        if (age < 0) {
            LOGGER.log(Level.SEVERE, "Age cannot be negative");
            throw new IllegalArgumentException("Age cannot be negative");
        }
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() == age) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> listStudentsByLastName() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(Student::getLastName));
        return sorted;
    }

    @Override
    public List<Student> listStudentsByBirthDate() {
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort(Comparator.comparing(Student::getDateOfBirth));
        return sorted;
    }

    private void validateFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.isEmpty()) {
            LOGGER.log(Level.SEVERE, "First name cannot be empty");
            throw new IllegalArgumentException("First name cannot be empty");
        }
    }

    private void validateLastName(String lastName) throws IllegalArgumentException {
        if (lastName.isEmpty()) {
            LOGGER.log(Level.SEVERE, "Last name cannot be empty");
            throw new IllegalArgumentException("Last name cannot be empty");
        }
    }

    private void validateDateOfBirth(LocalDate dateOfBirth) throws IllegalArgumentException {
        int minYear = 1900;
        int maxYear = LocalDate.now().getYear() - 18;
        int year = dateOfBirth.getYear();
        if (year < minYear || year > maxYear) {
            LOGGER.log(Level.SEVERE, "Date of birth should be between " + minYear + " and " + maxYear);
            throw new IllegalArgumentException("Date of birth should be between " + minYear + " and " + maxYear);
        }
    }

    private void validateGender(Gender gender) throws IllegalArgumentException {
        if (gender != Gender.MALE && gender != Gender.FEMALE) {
            LOGGER.log(Level.SEVERE, "Gender should be MALE or FEMALE");
            throw new IllegalArgumentException("Gender should be MALE or FEMALE");
        }
    }

    private void validateId(String id) throws IllegalArgumentException {
        if (id.isEmpty()) {
            LOGGER.log(Level.SEVERE, "ID cannot be empty");
            throw new IllegalArgumentException("ID cannot be empty");
        }
        if (id.length() != 13) {
            LOGGER.log(Level.SEVERE, "ID should have 13 digits");
            throw new IllegalArgumentException("ID should have 13 digits");
        }
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (c < '0' || c > '9') {
                LOGGER.log(Level.SEVERE, "ID should contain only digits");
                throw new IllegalArgumentException("ID should contain only digits");
            }
        }
        int year = Integer.parseInt(id.substring(1, 3));
        int month = Integer.parseInt(id.substring(3, 5));
        int day = Integer.parseInt(id.substring(5, 7));
        if (month < 1 || month > 12) {
            LOGGER.log(Level.SEVERE, "Invalid month in ID");
            throw new IllegalArgumentException("Invalid month in ID");
        }
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        if (day < 1 || day > maxDay) {
            LOGGER.log(Level.SEVERE, "Invalid day in ID");
            throw new IllegalArgumentException("Invalid day in ID");
        }
        int currentYear = LocalDate.now().getYear() % 100;
        if (year > currentYear) {
            year += 1900;
        } else {
            year += 2000;
        }
        LocalDate dob = LocalDate.of(year, month, day);
        validateDateOfBirth(dob);
    }

    public void clear() {
        students.clear();
    }
}
