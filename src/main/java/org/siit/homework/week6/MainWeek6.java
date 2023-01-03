package org.siit.homework.week6;

import java.util.Scanner;

public class MainWeek6 {
    public static void main(String[] args) {

        System.out.println("This is the main class for week 6 homework");
        System.out.println("First commit");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression to be calculated: ");
        String expression = scanner.nextLine();

        ExpressionCalculator calculator = new ExpressionCalculator();

        System.out.println(calculator.calculate(expression));
    }
}
