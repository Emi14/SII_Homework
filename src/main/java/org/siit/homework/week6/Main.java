package org.siit.homework.week6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an expression in the format '<value> <unit> [+/-] <value> <unit> = <unit>':");
            String input = scanner.nextLine();

            if (input.equals("quit")) {
                System.out.println("Exiting program...");
                break;
            }
            MetricSystemCalculator calculator = new MetricSystemCalculator();
            calculator.evaluateMetricExpression(input);
        }
    }
}





