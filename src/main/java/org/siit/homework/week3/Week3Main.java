package org.siit.homework.week3;

import java.util.Scanner;

import static org.siit.homework.week3.Homework3.calculatePrice;

public class Week3Main {
    public static void main(String[] args) {
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the base price: ");
            double basePrice = scanner.nextDouble();

            System.out.print("Enter the VAT percentage: ");
            double vatPercentage = scanner.nextDouble();

            double finalPrice = calculatePrice(basePrice, vatPercentage);
            System.out.println("The final price is: " + finalPrice);

        }
    }
}