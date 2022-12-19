package org.siit.homework.week7.java;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRepository {


    List<Student> studentList = new ArrayList<>();
    /// Student("Last","Name",2002,"M","3214");
    /// Student("First","Name",2001,"F","1234");
    /// delete("1234")



    public void add(Student student) throws Exception {
        String eMessage="";

        if(student.getFirstName().isEmpty())
            eMessage+="prenumele este gol\n";
        if(student.getLastName().isEmpty())
            eMessage+="numele este gol\n";

        if(student.getDateOfBirth()<1900 || student.getDateOfBirth()> LocalDate.now().getYear()){
           eMessage+="anul nasterii in afara intervalului\n";
        }
        if( !(student.getGender().equals("M")) && !(student.getGender().equals("m")) && !(student.getGender().equals("F")) && !(student.getGender().equals("f")))
        {
            eMessage+="gender invalid";
        }
        Exception e = new Exception(eMessage);
        if(!eMessage.isEmpty()){
            throw e;
        }

        studentList.add(student);
    }

    public void delete(String ID) throws Exception {
        if(ID.isEmpty()){
            throw new Exception("ID invalid\n");
        }

        boolean gasit=false;
        for(Student student : studentList){
            if(student.getID().equals(ID))
            {
                gasit=true;
                studentList.remove(student);
            }
        }
        if(!gasit){
            throw new Exception("studentul nu exista\n");
        }
    }

    private boolean isNumber(String string){
        for(int i=0;i<string.length();i++)
            if(string.charAt(i)<'0' || string.charAt(i)<'9')
                return false;
        return true;
    }


    public List<Student> retriveAll(String age) throws Exception {
        if(!isNumber(age))
        {
            throw new Exception("varsta invalida!\n");
        }

        int ageInt = Integer.parseInt(age);

        List<Student> students= new ArrayList<>();
        for(Student student : studentList){
            if(ageInt==LocalDate.now().getYear()-student.getDateOfBirth())
                students.add(student);
        }
        return students;

    }
    public List<Student> list(String tipSortare) throws Exception {
        if(tipSortare.isEmpty())
            throw new Exception("tip sortare este gol\n");

        if(tipSortare.equals("Last Name")){
            studentList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getLastName().compareTo(o2.getLastName());
                }
            });

        }
        if(tipSortare.equals("Birth Date")){
            studentList.sort(new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getDateOfBirth()-o2.getDateOfBirth();
                }
            });

        }

        return  studentList;

    }





}
