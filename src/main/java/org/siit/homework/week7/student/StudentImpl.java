package org.siit.homework.week7.student;

import org.siit.homework.week7.comparator.ComparatorByBirthDate;
import org.siit.homework.week7.comparator.ComparatorByLastName;
import org.siit.homework.week7.exception.AddStudentException;
import org.siit.homework.week7.exception.DeleteStudentException;
import org.siit.homework.week7.exception.ListException;
import org.siit.homework.week7.exception.RetrieveException;

import java.time.Year;
import java.util.*;

public class StudentImpl implements IStudent
{
    private final String [] genderArray = {"MALE","FEMALE","Male","Female","male","female","m","f","M","F"};
    private int formatId;
    Map<String, Student> students;


    public StudentImpl() {
        this.students = new HashMap<>();
    }

    @Override
    public Student addStudent(String firstName, String lastName, String dateOfBirth, String gender, String id) throws AddStudentException {

        if (Objects.isNull(firstName)) {
            throw new AddStudentException("Invalid first name format");
        }
        if (Objects.isNull(lastName)) {
            throw new AddStudentException("Invalid last name format");
        }
        if (dateOfBirth.length() != 10) {
            throw new AddStudentException("Invalid date of birth format");
        }
        if (Arrays.stream(genderArray).noneMatch(gender::equals)) {
            throw new AddStudentException("Invalid gender format");
        }
        if (id.length() != 13) {
            throw new AddStudentException("Invalid id format");
        }

        Student student = new Student(firstName, lastName, dateOfBirth, gender, id);
        students.put(student.getId(), student);

        char [] idArray = id.toCharArray();
        int idAge;
        Year thisYear = Year.now();
        int year = thisYear.getValue();
        if(idArray[1] == '0') {
            idAge = 2000 + Character.getNumericValue(idArray[2]);
            students.get(id).setAge(year - idAge);
        }
        else {
            idAge = Character.getNumericValue(idArray[1]) * 10 + Character.getNumericValue(idArray[2]);
            if(idAge > year % 100)
            {
                students.get(id).setAge(year - (19*100 + idAge));
            }
            else students.get(id).setAge(year - (20*100 + idAge));
        }
        return student;
    }

    @Override
    public void deleteStudent(String id) throws DeleteStudentException {
        Student student = students.get(id);
        if (Objects.isNull(id)) {
            throw new DeleteStudentException("Invalid id format");
        } else if (id.length() != 13) {
            throw new DeleteStudentException("Invalid id format");
        }
        if(Objects.isNull(student)) {
            throw new DeleteStudentException("The student is not exist");
        }
        students.remove(id);
    }


    @Override
    public String retrieveAllByAge(int age) throws RetrieveException {
        if(age < 0)
        {
            throw  new RetrieveException("Negative number");
        }

        Set<Student> studentHashSet = new HashSet<>(students.values());
        for (Student student : studentHashSet) {
            if(age == student.getAge())
            {
               return student.toString();
            }
        }
        return "No student with this age";
    }

    @Override
    public String list(String condition) throws ListException {
        if(Objects.isNull(condition)){
            throw new ListException("Invalid condition");
        }
        if(condition.equals("Birth Date"))
        {
            Set<Student> studentTreeSet = new TreeSet<>(new ComparatorByBirthDate());
            studentTreeSet.addAll(students.values());
            return studentTreeSet.toString();
        }
        if(condition.equals("Last Name"))
        {
            Set<Student> studentTreeSet = new TreeSet<>(new ComparatorByLastName());
            studentTreeSet.addAll(students.values());
            return studentTreeSet.toString();
        }
        return null;
    }

}
