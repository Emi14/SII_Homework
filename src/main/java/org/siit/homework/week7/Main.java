package org.siit.homework.week7;


import org.siit.homework.week7.exception.EmptyVariableException;
import org.siit.homework.week7.exception.InvalidInputFormatException;
import org.siit.homework.week7.exception.OutOfBoundsException;

import java.time.DateTimeException;
import java.util.*;

import static org.siit.homework.week7.StudentRepository.addStudent;

public class Main {

    public static final String QUIT_MENU = "QUIT";
    public static String userInputFirstName;
    public static String userInputLastName;
    public static String userInputDateOfBirth;
    public static String userInputGender;
    public static String userInputId;

    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to StdRepo!");
            System.out.println("You can choose from the following operations by typing the number:");
            System.out.println("1 - To add a student to the repo");
            System.out.println("2 - To delete a student from the repo");
            System.out.println("3 - To retrieve all students that meet the age criteria");
            System.out.println("4 - To list all the students from the repo");
            System.out.println("QUIT - To exit the app");

            System.out.print("Type here: ");
            String operationChoice = scanner.nextLine();
            while (!operationChoice.equals(QUIT_MENU)) {
                if (operationChoice.equals("1")) {
                    System.out.println("You chose to add a new student to the repository");
                    System.out.println("Please provide the following details:");
                    try {
                        System.out.print("Student's first name: ");
                        userInputFirstName = scanner.nextLine();
                        System.out.print("Student's last name: ");
                        userInputLastName = scanner.nextLine();
                        System.out.print("Student's date of birth (YYY-MM-DD format): ");
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
                    }
                    catch (DateTimeException e) {
                        System.out.println("Birth date should respect the YYYY-MM-DD format");
                        break;
                    }
                    System.out.print("Choose another operation: ");
                    operationChoice = scanner.nextLine();
                } //TODO maybe extract the menu to a different method so you can call it everytime
            }
        }


    }





//    private static void toBeIncluded() {
//        //Implemented minimal add operation
//        //Generating hashSet with id uniqueness
//        Set<Student> studentSet = new HashSet<>();
//        studentSet.add(new Student("Felix", "Cirebea", "1996-11-25", "M", "123456"));
//        studentSet.add(new Student("Radu", "Lascau", "1996-11-26", "M", "645642"));
//        studentSet.add(new Student("Maria", "Pop", "1996-12-20", "F", "867466"));
//        studentSet.add(new Student("Daria", "Pop", "1985-03-15", "F", "867476"));
//        studentSet.add(new Student("Daria", "Cirebea", "1985-03-15", "F", "867477"));
//        //Printing hashSet
//        for (Student student : studentSet) {
//            System.out.println(student);
//        }
//        System.out.println();
//
//        //Implemented minimal delete operation
//        String idToBeRemoved = "867466";
//        //Removing Maria Pop
//        studentSet.removeIf(student -> student.getId().equals(idToBeRemoved));
//        for (Student student : studentSet) {
//            System.out.println(student);
//        }
//        System.out.println();
//
//        //Implemented minimal retrieve operation based on user input age
//        //AgeCalculator based on input compared to currentDate
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Type the age desired: ");
//        int input = Integer.parseInt(scanner.nextLine());
//        for (Student student : studentSet) {
//            int age = calculateAge(student.getBirthDate());
//            if (age == input) {
//                System.out.println(student);
//            }
//        }
//
//        //implemented minimal list students operation
//        List<Student> listByBirthDate;
//        List<Student> listByLastName;
//        String listInput = scanner.nextLine();
//        scanner.close();
//        if (listInput.equals("last-name")) {
//            listByLastName = new ArrayList<>(studentSet);
//            listByLastName.sort(new ComparatorByLastName());
//            for (Student student : listByLastName) {
//                System.out.println(student);
//            }
//        } else if (listInput.equals("birthdate")) {
//            listByBirthDate = new ArrayList<>(studentSet);
//            listByBirthDate.sort(new ComparatorByBirthDate());
//            for (Student student : listByBirthDate) {
//                System.out.println(student);
//            }
//        } else {
//            System.err.println("Error");
//        }
//
//        //TODO needs scanner to be created
////        String stringInput = scanner.nextLine(); //reads the year from kb on YYYY-MM-DD
////        System.out.println(isValidBirthDate(stringInput)); //checks if the format is respected
//    }


}