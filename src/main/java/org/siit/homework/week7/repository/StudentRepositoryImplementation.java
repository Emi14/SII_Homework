package org.siit.homework.week7.repository;

import org.siit.homework.week7.algorithm.Algorithm;
import org.siit.homework.week7.comparator.SortByBirthDate;
import org.siit.homework.week7.comparator.SortByLastName;
import org.siit.homework.week7.exception.*;
import org.siit.homework.week7.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepositoryImplementation implements StudentRepository {
    List<Student> studentList = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        studentList.sort(new SortByBirthDate().thenComparing(new SortByLastName()));
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        Algorithm algorithm = new Algorithm();
        for (Student elem : studentList) {
            if (elem.getID().equals(student.getID())) {
                throw new BadRequestException("ID " + student.getID() + " already taken");
            }
        }
        if (student.getFirstName().isEmpty()) {
            throw new EmptyNameException("The first name can not be empty");
        }
        if (student.getLastName().isEmpty()) {
            throw new EmptyNameException("The last name can not be empty");
        }
        if (!algorithm.isBetween(student.getBirthDate().getYear(), 1900, LocalDate.now().getYear())) {
            throw new BirthDateOutOfIndex("The birth date must be between " + 1900 + " and " + LocalDate.now().getYear());
        }
        if (!(student.getGender().equalsIgnoreCase("M") || student.getGender().equalsIgnoreCase("F"))) {
            throw new UnknownGenderException(student.getGender() + " invalid gender");
        }
        studentList.add(student);
    }

    @Override
    public void deleteStudent(String ID) {
        if (ID.isEmpty()) {
            throw new InvalidIdentifierException("Invalid ID");
        }
        boolean found = false;
        for (Student student : studentList) {
            if (student.getID().equals(ID)) {
                found = true;
                studentList.remove(student);
                break;
            }
        }
        if (!found) {
            throw new DataNotFoundException("Student with id " + ID + " does not exist");
        }
    }

    @Override
    public List<Student> retrieveStudentByAge(String age) {
        Algorithm algorithm = new Algorithm();
        if (!algorithm.isNumber(age) || Integer.parseInt(age) < 0) {
            throw new InvalidNumberException("The age must be a number greater or equal to 0");
        }
        int ageX = Integer.parseInt(age);
        List<Student> studentListWithAgeX = studentList
                .stream()
                .filter(student -> ageX == Math.abs(algorithm.calculateAge(student.getBirthDate(), LocalDate.now())))
                .toList();
        if (studentListWithAgeX.isEmpty()) {
            throw new DataNotFoundException("Students with age " + ageX + " do not exist");
        }
        return studentListWithAgeX;
    }
}
