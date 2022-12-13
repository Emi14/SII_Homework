package org.siit.homework.week7;

import org.siit.homework.week7.comparator.ComparatorByBirthDate;
import org.siit.homework.week7.comparator.ComparatorByLastName;
import org.siit.homework.week7.exception.EmptyVariableException;
import org.siit.homework.week7.exception.InvalidInputFormatException;
import org.siit.homework.week7.exception.OutOfBoundsException;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.siit.homework.week7.Main.studentSet;

public class StudentRepository {

    private static List<Student> listByBirthDate;
    private static List<Student> listByLastName;

    public static void addStudent(Set<Student> studentSet, String firstName,
                                  String lastName, String birthDate, String gender,
                                  String id) throws EmptyVariableException, OutOfBoundsException, InvalidInputFormatException {

        LocalDate dateOfBirth = LocalDate.parse(birthDate);
        if (firstName.equals("")) {
            throw new EmptyVariableException("First name field cannot be empty");
        } else if (lastName.equals("")) {
            throw new EmptyVariableException("Last name field cannot be empty");
        } else if (dateOfBirth.getYear() <= 1900 || dateOfBirth.getYear() > LocalDate.now().getYear()) {
            throw new OutOfBoundsException("Birth date should be between 1900 and " + LocalDate.now().getYear());
        } else if (!isValidBirthDate(birthDate)) {
            throw new InvalidInputFormatException("Birth date should respect the YYYY-MM-DD format");
        } else if (!gender.equals("M") && !gender.equals("m") && !gender.equals("F") && !gender.equals("f")) {
            throw new InvalidInputFormatException("Gender should be M or F");
        } else if (id.equals("")) {
            throw new EmptyVariableException("CNP field cannot be empty");
        }
        studentSet.add(new Student(firstName, lastName, birthDate, gender, id));
    }

    private static boolean isValidBirthDate(String input) { //TODO regex tutorial
        //With this method you can enforce a pattern on user input birthdate
        String regex = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$"; //stack overflow regex
        // to check YYYY-MM-DD format of birthdate
        Pattern p = Pattern.compile(regex); //compile the regex
        Matcher m = p.matcher(input); //tries to match input against regex
        return m.matches();
    }

    //TODO tests tests tests
    public static void retrieveStudentsOfAge(String input) throws InvalidInputFormatException {
        int inputAge = Integer.parseInt(input);
        if (inputAge < 0) {
            throw new InvalidInputFormatException("Age cannot be negative");
        }
        for (Student student : studentSet) {
            int studentAge = calculateAge(student.getBirthDate());
            if (studentAge == inputAge) {
                System.out.println(student);
            }
        }
    }

    private static int calculateAge(String birthDate) {
        //Calculates age being the difference between getBirthDate result and currentDate
        LocalDate dateOfBirth = LocalDate.parse(birthDate);
        LocalDate currentDate = LocalDate.now();
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void deleteStudent(String id) throws EmptyVariableException {
        if (studentSet.isEmpty()) {
            throw new EmptyVariableException("The repository is currently empty");
        }
        if (!studentSet.removeIf(student -> student.getId().equals(id))) {
            throw new EmptyVariableException("Student not found");
        } else {
            System.out.println("The student with CNP: " + id + " has been removed");
        }
    }

    public static void listSortedStudents(String input) throws InvalidInputFormatException {
        if (input.equals("1")) {
            listByLastName = new ArrayList<>(studentSet);
            listByLastName.sort(new ComparatorByLastName());
            for (Student student : listByLastName) {
                System.out.println(student);
            }
        } else if (input.equals("2")) {
            listByBirthDate = new ArrayList<>(studentSet);
            listByBirthDate.sort(new ComparatorByBirthDate());
            for (Student student : listByBirthDate) {
                System.out.println(student);
            }
        } else {
            throw new InvalidInputFormatException("Invalid input");
        }
    }

}