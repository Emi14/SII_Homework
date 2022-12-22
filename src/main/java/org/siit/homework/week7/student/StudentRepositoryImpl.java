package org.siit.homework.week7.student;

import org.siit.homework.week7.comparator.StudentComparatorByBirthDate;
import org.siit.homework.week7.comparator.StudentComparatorByLastName;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.StudentCreationException;
import org.siit.homework.week7.exception.StudentException;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepositoryImpl implements IStudentRepository {


    private final Set<Student> studentSet;
    int currentYear = Year.now().getValue();

    public StudentRepositoryImpl() {
        studentSet = new HashSet<>();
    }

    @Override
    public void addStudent(String firstName, String lastName, int birthDate, String gender, String cnp) throws StudentCreationException {
        if(firstName.isEmpty() || lastName.isEmpty()) {
            throw new StudentCreationException("First Name or Last Name should not be empty.");
        }
        if(birthDate < 1900 || birthDate > currentYear - 18 ) {
            throw new StudentCreationException("Date of birth is invalid.");
        }
        if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female") ) {
            throw new StudentCreationException("Gender type should be: male or female");
        }
        Student student = new Student(firstName, lastName, birthDate, gender, cnp);
        studentSet.add(student);
    }

    @Override
    public void deleteStudent(String cnp) throws DeleteStudentException, StudentException {

        if(studentSet.isEmpty()){
            throw new StudentException("Student repository is empty.");
        }
        for (Student student: studentSet){
            if(student.getCnp().equals(cnp)) {
                studentSet.remove(student);
                return;
            }
        }
        throw new DeleteStudentException("The student cannot be found.");
    }

    @Override
    public List<Student> retrieveAllStudentsOfAgeX(int studentAgeX) throws StudentException {
        if(studentSet.isEmpty()){
            throw new StudentException("Student repository is empty.");
        }
        List<Student> studentsOfAgeX = new ArrayList<>();
        for(Student student: studentSet) {
            int studentAge = currentYear - student.getBirthDate();
            if(studentAgeX == studentAge) {
                studentsOfAgeX.add(student);
            }
        }
        if(studentsOfAgeX.isEmpty()){
            throw new StudentException("No students of age " + studentAgeX + ", were found.");
        }
        return studentsOfAgeX;
    }

    @Override
    public List<Student> listStudentByLastName() throws StudentException {
        if(studentSet.isEmpty()){
            throw new StudentException("Student repository is empty.");
        }
        List<Student> studentsListedByLastName = new ArrayList<>();
        studentsListedByLastName.addAll(studentSet);
        studentsListedByLastName.sort(new StudentComparatorByLastName());

        return studentsListedByLastName;
    }

    @Override
    public List<Student> listStudentByBirthDate() throws StudentException {
        if(studentSet.isEmpty()){
            throw new StudentException("Student repository is empty.");
        }
        List<Student> studentsListedByBirthDate = new ArrayList<>();
        studentsListedByBirthDate.addAll(studentSet);
        studentsListedByBirthDate.sort(new StudentComparatorByBirthDate());

        return studentsListedByBirthDate;
    }


}
