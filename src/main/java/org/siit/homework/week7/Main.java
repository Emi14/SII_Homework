package org.siit.homework.week7;


import org.siit.homework.week7.exception.EmptyVariableException;
import org.siit.homework.week7.exception.InvalidInputFormatException;
import org.siit.homework.week7.exception.OutOfBoundsException;

import java.time.DateTimeException;
import java.util.*;

import static org.siit.homework.week7.StudentRepository.*;

public class Main {

    public static final String QUIT_MENU = "QUIT";
    public static String userInputFirstName;
    public static String userInputLastName;
    public static String userInputDateOfBirth;
    public static String userInputGender;
    public static String userInputId;
    public static Set<Student> studentSet = new HashSet<>();

    //TODO refactoring

    public static void main(String[] args) {

        //TODO maybe extract the menu to a different method so you can call it everytime
        try (Scanner scanner = new Scanner(System.in)) { //TODO get rid of the try and close the scanner
            System.out.println("Welcome to StdRepo!");
            System.out.println("You can choose from the following operations by typing the number:");
            System.out.println("1 - To add a student to the repo");
            System.out.println("2 - To delete a student from the repo");
            System.out.println("3 - To retrieve all students that meet the age criteria");
            System.out.println("4 - To list all the students from the repo");
            System.out.println("QUIT - To exit the app");

            //TODO make it not crash at every single little typo
            System.out.print("Type here: ");
            String operationChoice = scanner.nextLine();
            while (!operationChoice.equals(QUIT_MENU)) {
                if (operationChoice.equals("1")) {
                    System.out.println("You chose to add a new student to the repository!");
                    System.out.println("Please provide the following details:");
                    try {
                        System.out.print("Student's first name: ");
                        userInputFirstName = scanner.nextLine();
                        System.out.print("Student's last name: ");
                        userInputLastName = scanner.nextLine();
                        System.out.print("Student's date of birth (YYYY-MM-DD format): ");
                        userInputDateOfBirth = scanner.nextLine();
                        System.out.print("Student's gender (M/F): ");
                        userInputGender = scanner.nextLine();
                        System.out.print("Student's CNP: ");
                        userInputId = scanner.nextLine();
                        addStudent(studentSet,
                                userInputFirstName,
                                userInputLastName,
                                userInputDateOfBirth,
                                userInputGender,
                                userInputId);
                    } catch (EmptyVariableException | InvalidInputFormatException | OutOfBoundsException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please refresh the application");
                        break;
                    } catch (DateTimeException e) {
                        System.out.println("Birth date should respect the YYYY-MM-DD format");
                        break;
                    }
                    System.out.print("Choose another operation: ");
                    operationChoice = scanner.nextLine();
                }
                if (operationChoice.equals("2")) {
                    System.out.println("You chose to delete a student from the repository!");
                    System.out.print("Please enter the CNP of the student you want to delete: ");
                    String idToBeRemoved = scanner.nextLine();
                    try {
                        deleteStudent(idToBeRemoved);
                    } catch (EmptyVariableException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please refresh the application");
                        break;
                    }
                    System.out.print("Choose another operation: ");
                    operationChoice = scanner.nextLine();
                }
                if (operationChoice.equals("3")) {
                    System.out.println("You chose to retrieve all students of specified age!");
                    System.out.print("Please enter the age: ");
                    String ageToRetrieveBy = scanner.nextLine();
                    try {
                        retrieveStudentsOfAge(ageToRetrieveBy);
                    } catch (InvalidInputFormatException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please refresh the application");
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be in number format. NO LETTERS ALLOWED");
                        System.out.println("Please refresh the application");
                        break;
                    }
                    System.out.print("Choose another operation: ");
                    operationChoice = scanner.nextLine();
                }
                if (operationChoice.equals("4")) {
                    System.out.println("You chose to list all the students ordered by Last Name or Birth Date");
                    System.out.println("Please select the criteria by typing the corresponding number:");
                    System.out.println("1. By last name");
                    System.out.println("2. By birth date");
                    String sortingCriteria = scanner.nextLine();
                    try {
                        listSortedStudents(sortingCriteria);
                    } catch (InvalidInputFormatException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Please refresh the application");
                        break;
                    }
                    System.out.print("Choose another operation: ");
                    operationChoice = scanner.nextLine();
                }
            }
        }
    }
}