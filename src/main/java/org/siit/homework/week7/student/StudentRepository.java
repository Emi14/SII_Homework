package org.siit.homework.week7.student;

import org.siit.homework.week7.comparator.DateOfBirthComparator;
import org.siit.homework.week7.comparator.LastNameComparator;
import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListStudentException;
import org.siit.homework.week7.exception.RetrieveException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements StudentInterface{

    List<Student> studentList = new ArrayList<>();
    @Override
    public void add(Student student) throws AddStudentException, RetrieveException {
        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(student.getId())) {
                throw new RetrieveException("ID " + student.getId() + " already taken");
            }
        }

        if (student.getFirstName().isEmpty()) {
            throw new AddStudentException("The first name can not be empty");
        }

        if (student.getLastName().isEmpty()) {
            throw new AddStudentException("The last name can not be empty");
        }

        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        if (student.getDateOfBirth().isBefore(LocalDate.of(1900, 1, 1)) || student.getDateOfBirth().isAfter(now)) {
            throw new AddStudentException("The birth date must be between 1900 and " + currentYear);
        }

        String gender = student.getGender().toString().toUpperCase();
        if (!gender.equals("M") && !gender.equals("F") && !gender.equals("MALE") && !gender.equals("FEMALE")) {
            throw new AddStudentException(gender + " is an invalid gender");
        }

        studentList.add(student);
    }

    @Override
    public void delete(String id) throws DeleteStudentException  {
        boolean isRemoved = false;
        for (Student existingStudent : studentList) {
            if (existingStudent.getId().equals(id)) {
                studentList.remove(existingStudent);
                isRemoved = true;
                break;
            }
        }
        if (!isRemoved) {
            throw new DeleteStudentException("Student with ID " + id + " not found.");
        }
    }

    @Override
    public List<Student> retrieveAll() throws RetrieveException  {
        List<Student> result = new ArrayList<>();
        LocalDate now = LocalDate.now();
        for (Student student : studentList) {
            LocalDate dateOfBirth = student.getDateOfBirth();
            int age = Period.between(dateOfBirth, now).getYears();
            if (age < 0) {
                throw new RetrieveException("Invalid age for student " + student.getId());
            }
            if (age >= 18) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public List<Student> retrieveByAge(int age) throws RetrieveException {
        List<Student> matchingStudents = new ArrayList<>();

        LocalDate now = LocalDate.now();

        for (Student student : studentList) {
            LocalDate birthdate = student.getDateOfBirth();
            int studentAge = Period.between(birthdate, now).getYears();

            if (studentAge == age) {
                matchingStudents.add(student);
            }
        }

        return matchingStudents;
    }

    @Override
    public List<Student> list(String orderBy) throws ListStudentException {
        if (!orderBy.equalsIgnoreCase("last name") && !orderBy.equalsIgnoreCase("date of birth")) {
            throw new ListStudentException("Invalid orderBy parameter");
        }

        List<Student> sortedStudents = new ArrayList<>(studentList);

        if (orderBy.equalsIgnoreCase("last name")) {
            Collections.sort(sortedStudents, new LastNameComparator());
        } else {
            Collections.sort(sortedStudents, new DateOfBirthComparator());
        }

        return sortedStudents;
    }
}
