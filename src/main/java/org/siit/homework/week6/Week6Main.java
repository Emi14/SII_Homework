package org.siit.homework.week6;

import java.util.Scanner;

public class Week6Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the expression: ");
        String expression = scanner.nextLine();

        Calculator calculator = new Calculator();
        calculator.computeString(expression);

//        You can use this inputs
//        1000 m + 1 m - 10 mm = 1000990 mm
//        150 cm + 5 m = 650 cm
//        10 km + 30 m = 1030 m
//        55 m - 5 dm + 2 dm + 1 km = 10547 dm


    }
}
