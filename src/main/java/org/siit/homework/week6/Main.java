package org.siit.homework.week6;
public class Main {
//    - write a calculator that is capable of computing a metric distance value from an expression
//    that contains different scales and systems
//    - output should be specified by the user
//    - only addition and subtraction is allowed
//    - implement the calculator and write UNIT TESTS that prove that the computations are correct
//    - supported formats: mm, cm, dm, m, km
//    - output is in the lowest unit, expression: 10 cm + 1 m - 10 mm = 1090 mm
    public static void main(String[] args) {
        String expression = "10 cm + 1 m - 10 mm = 1090 mm";
        Calculator calculator = new Calculator();

        System.out.println("\nThe left side of the expression: '10 cm + 1 m - 10 mm = 1090 mm' was checked by the calculator.\n" +
                "The result is  --> " + calculator.calculateExpression(expression));
    }

             ////// TESTS AVAILABLE. PLEASE CHECK HERE: src/test/java/org/siit/homework/week6 //////

}
