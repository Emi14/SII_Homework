package org.siit.homework.week6;

public class Main {
    public static void main(String[] args) {
        System.out.println("This is the main class for week 6 homework");
        System.out.println("Mesaj de la Razvan");
        Calculator calculator = new Calculator();

        calculator.expression("10 cm + 1 m - 10 mm");
        System.out.println(calculator.getResult()+" mm");
    }
}
