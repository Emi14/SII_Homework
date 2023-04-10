package org.siit.projects.metricDistanceCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        String expression = "10 cm + 1 m - 10 mm = 1090 mm";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter expression to be calculated: ");
        String expression = scanner.nextLine();

        Calculator calculator = new Calculator();

        System.out.println(calculator.calculateExpression(expression));


    }
}
