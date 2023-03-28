package org.siit.homework.week6;

public class Main {
    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm = 1090 mm";
        System.out.println("Expression: " + expression);

        String result = Calculator.checkingUserCalculation(expression);
        System.out.println("Result: " + result);

        System.out.println("*******************************************************************************************");

        String expression1 = "10 cm + 1 m - 10 mm = 1090 mm";
        System.out.println("Expression: " + expression1);
        String result1 = Calculator.checkingUserCalculation(expression1);
        System.out.println(result1);

        System.out.println("*******************************************************************************************");

        String expression2 = "1 cm + 1 m + 11 mm = 999 mm";
        System.out.println("Expression: " + expression2);
        String result2 = Calculator.checkingUserCalculation(expression2);
        System.out.println(result2);

        System.out.println("*******************************************************************************************");

        String expression3 = "1 m - 1 dm - 11 mm = 999 mm";
        System.out.println("Expression: " + expression3);
        String result3 = Calculator.checkingUserCalculation(expression3);
        System.out.println(result3);

        System.out.println("*******************************************************************************************");

        String expression4 = "10 cm * 2 m = ";
        System.out.println("Expression: " + expression4);
        String result4 = Calculator.checkingUserCalculation(expression4);
        System.out.println(result4);

    }
}

