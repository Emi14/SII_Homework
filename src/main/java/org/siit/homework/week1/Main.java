package org.siit.homework.week1;

public class Main {
    public static void main(String[] args) {
                                      // Exercise 1: //
        System.out.println("-------------------------------------------------------------------" +
                "\nExercise 1: Calculate the sum of the first 100 numbers higher than 0" +
                "\n...................................................................");
        Sum sum = new Sum();
        sum.sum();
        System.out.println("-------------------------------------------------------------------\n");
                                      // Exercise 2: //
        System.out.println("-------------------------------------------------------------------" +
                "\nExercise 2: Display the smallest number from an array of numbers:" +
                "\n...................................................................");
        SmallestNumber smallestNumber = new SmallestNumber();
        smallestNumber.smallestNumber();
        System.out.println("-------------------------------------------------------------------\n");
                                      // Exercise 3: //
        System.out.println("-------------------------------------------------------------------" +
                "\nExercise 3: Display the max digit of a number " +
                "\n...................................................................");
        MaxDigit maxDigit = new MaxDigit();
        maxDigit.maxDigit();
        System.out.println("-------------------------------------------------------------------\n");
                                      // Exercise 4: //
        System.out.println("-------------------------------------------------------------------" +
                "\nExercise 4: Check if a number is palindrome " +
                "\n...................................................................");
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome();
        System.out.println("-------------------------------------------------------------------\n");
                                      // Exercise 5: //
        System.out.println("-------------------------------------------------------------------" +
                "\nExercise 5: Display all the prime numbers lower than a given number " +
                "\n...................................................................");
        PrimeNumber primeNumber = new PrimeNumber();
        primeNumber.primeNumbers();
        System.out.println("-------------------------------------------------------------------\n");

    }
}