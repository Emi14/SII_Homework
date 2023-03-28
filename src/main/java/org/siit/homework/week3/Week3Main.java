package org.siit.homework.week3;

import java.util.Scanner;

/**
 * The main program receives two numbers (the base price and the VAT) as input from the user,
 * then, it calls the calculatePrice method, passing the two numbers as parameters and displays
 * the result on the screen.
 */

public class Week3Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //User input for base price
        System.out.print("Type the base price of the product: ");
        double basePrice = scanner.nextDouble();
        //User input for VAT value
        System.out.print("Type the VAT (in percentage) for the product: ");
        double vat = scanner.nextDouble();

        System.out.println("The final price of your product is: " + calculatePrice(basePrice, vat));

    }

    /**
     * Calculates the final price of a product composed of a given a base price and the VAT percentage.
     *
     * @param basePrice
     * @param vat
     * @return final price of the product
     */
    public static double calculatePrice(double basePrice, double vat) {
        return basePrice + (basePrice * (vat/100));
    }

}