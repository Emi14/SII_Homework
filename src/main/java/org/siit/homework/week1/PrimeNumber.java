package org.siit.homework.week1;

public class PrimeNumber {
    // Display all the prime numbers lower than a given number //
    public int numOriginal = 10;
    int wholeNumber = numOriginal;

    public void primeNumbers() {
        System.out.println("Prime numbers smaller than " + numOriginal + " are: ");
        int i = 0;
        while (i < wholeNumber) {
            isPrime(i);
            i++;
            if (isPrime(i)) {
                System.out.println(i + " is a prime number.");
            }
        }
    }
    public boolean isPrime(int number) {
        if (number <= 2) {
            return (number == 2);
        }
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}


