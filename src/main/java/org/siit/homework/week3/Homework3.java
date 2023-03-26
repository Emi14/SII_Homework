package org.siit.homework.week3;

public class Homework3 {
    public static double calculatePrice(double basePrice, double vatPercentage) {
        double vatAmount = basePrice * (vatPercentage / 100);
        double finalPrice = basePrice + vatAmount;
        return finalPrice;
    }
}
