package org.siit.homework.week7;

import org.siit.homework.week7.student.IStudentRepository;
import org.siit.homework.week7.student.Student;
import org.siit.homework.week7.student.StudentRepositoryImpl;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final IStudentRepository studentRepository = new StudentRepositoryImpl();

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        studentMenu(logger);

    }

    private static void studentMenu(Logger logger) {
        boolean quit = false;
        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice: " );
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addStudentOption(logger);
                    break;
                case 2:
                    deleteStudentOption(logger);
                    break;
                case 3:
                    retrieveStudentOption(logger);
                    break;
                case 4:
                    listByLastNameOption(logger);
                    break;
                case 5:
                    listByBirtDateOption(logger);
                    break;
                case 6:
                    quit = true;
                    scanner.close();
                    System.out.println("Closing...");
                    break;
            }
        }
    }

    private static void listByBirtDateOption(Logger logger) {
        try{
            for(Student student: studentRepository.listStudentByBirthDate()){
                System.out.println(student);
            }
        }
        catch (Exception e) {
            logger.log(Level.FINE, e.getMessage());
        }
        finally {
            printInstructions();
        }
    }

    private static void listByLastNameOption(Logger logger) {
        try{
            for(Student student: studentRepository.listStudentByLastName()){
                System.out.println(student);
            }
        }
        catch (Exception e) {
            logger.log(Level.FINE, e.getMessage());
        }
        finally {
            printInstructions();
        }
    }

    private static void retrieveStudentOption(Logger logger) {
        System.out.print("Please insert age here: ");
        int chooseAge = scanner.nextInt();
        scanner.nextLine();
        try{
            for(Student student: studentRepository.retrieveAllStudentsOfAgeX(chooseAge) ) {
                System.out.println(student);
            }
        }
        catch (Exception e) {
            logger.log(Level.INFO, e.getMessage());
        }
        finally {
            printInstructions();
        }
    }

    private static void deleteStudentOption(Logger logger) {
        String cnp;
        System.out.print("Please provide the student's CNP: ");
        cnp = scanner.nextLine();
        try {
            studentRepository.deleteStudent(cnp);
            System.out.println("The student with CNP " + cnp + " has been removed from the list.");
        }
        catch (Exception e) {
            logger.log(Level.FINE, e.getMessage());
        }
        finally {
            printInstructions();
        }
    }

    private static void addStudentOption(Logger logger) {
        System.out.println("Please provide the following details.");
        System.out.print("First name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Year of birth: ");
        int birthDate = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Gender (male/female): ");
        String gender = scanner.nextLine();
        System.out.print("CNP: ");
        String cnp = scanner.nextLine();
        try {
            studentRepository.addStudent(firstName, lastName, birthDate, gender, cnp);
            System.out.println("The student was added to the list.");

        }
        catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e.getCause());
        }
        finally {
            printInstructions();
        }
    }
    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To add a student to the list.");
        System.out.println("\t 2 - To delete a student from the list.");
        System.out.println("\t 3 - To retrieve all student with a certain age from the list.");
        System.out.println("\t 4 - To list the students, ordered by Last Name.");
        System.out.println("\t 5 - To list the students, ordered by Birth Date.");
        System.out.println("\t 6 - To quit the application.");

    }

}