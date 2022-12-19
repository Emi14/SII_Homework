package org.siit.homework.week7.java;

import java.util.List;

public class Main {
    public static void main(String[] args)  {
        Student student = new Student("first","name3",2013,"F","1234");
        Student student1 = new Student("first","name1",2010,"F","1234");
        Student student2 = new Student("first","name2",2001,"F","1234");


        StudentRepository studentRepository = new StudentRepository();
        try {
            studentRepository.add(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            studentRepository.add(student1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            studentRepository.add(student2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//
//        String ID1 = "";
//        String ID2 = "4321";
//        String ID3 = "1234";
//
//        try {
//            studentRepository.delete(ID1);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            studentRepository.delete(ID2);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        try {
//            studentRepository.delete(ID3);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }

        try {
            List<Student> studentList = studentRepository.list("Last Name");
            for(Student studentInLista : studentList){
                System.out.println(studentInLista);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();


        try {
            List<Student> studentList = studentRepository.list("Birth Date");
            for(Student studentInLista : studentList){
                System.out.println(studentInLista);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
