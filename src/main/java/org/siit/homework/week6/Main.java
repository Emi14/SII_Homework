package org.siit.homework.week6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 6 homework");
        System.out.println();
        System.out.print("Type your expression: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        CalculatorInterface calculator = new Calculator();
        calculator.computeString(expression);
    }
}
