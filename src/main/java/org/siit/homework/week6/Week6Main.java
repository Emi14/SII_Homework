package org.siit.homework.week6;

import java.util.Scanner;

public class Week6Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 6 homework");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the expression: ");
        String expression = scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.computeString(expression);

//        You can use this inputs
//        10 m + 1 m - 10 mm = 10990 mm
//        15 mm + 8 m = 801 cm
//        1000 mm + 3 km = 3001 m
//        20 m - 150 dm + 20 dm + 1 m = 80 dm


    }
}
