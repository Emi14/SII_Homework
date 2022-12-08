package org.siit.homework.week6;

public class Main {
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();
        calculator.expresion("10 cm + 1 m - 10 mm = 1090 mm");
        System.out.println(calculator.getResult());
        System.out.println(calculator.getAnswer());
    }
}
