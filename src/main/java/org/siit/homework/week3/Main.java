package org.siit.homework.week3;

public class Main {

//    Create a program which calculates the final price of a product.
//    Given a base price and the VAT (TVA in Romanian) percentage,
//    the program calculates the final price.
//    Perform the calculation in a method (function). The method, which we will name calculatePrice, receives two parameters
//    and returns a number. Think about the appropriate types for these numbers in the context of the problem we're solving.
//    The main program receives two numbers (the base price and the VAT) as input from the user.
//    Then, it calls the calculatePrice method, passing the two numbers as parameters.
//    The result returned by the method will be displayed on the screen.

    public static void main(String[] args) {
        VATCalculator vatCalculator = new VATCalculator();
        double fullPrice = vatCalculator.calculatePrice(153, 0.19);
        if (fullPrice == -1) {
            System.out.println("Please use a positive number for the Base Price");
        } else {
            System.out.println("The price of the product containing VAT is " +
                    fullPrice + " RON.");
        }
    }
}