package org.siit.homework.week3;

public class VATCalculator {
    public double calculatePrice(double basePrice, double VAT) {
        if (basePrice < 0) {
            return -1;
        }
        return (basePrice * VAT) + basePrice;
    }
}
