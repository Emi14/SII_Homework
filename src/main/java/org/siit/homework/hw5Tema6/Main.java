package org.siit.homework.hw5Tema6;

public class Main {
    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm = 1090 mm";
        Calculator calculator = new Calculator();

        System.out.println("Result: " + calculator.calculateExpression(expression));
    }
}