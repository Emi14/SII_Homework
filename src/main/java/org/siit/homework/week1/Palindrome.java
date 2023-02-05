package org.siit.homework.week1;

public class Palindrome {
    // Check if a number is palindrome //
    public int numberOriginal = 15551;

    public boolean isPalindrome() {
        if (numberOriginal < 0) {
            numberOriginal = numberOriginal * (-1);
        }
        int reverse = 0;
        int number = numberOriginal;
        while (number > 0) {
            int lastDigit = number % 10;
            number = number / 10;
            reverse = reverse * 10 + lastDigit;

        }
        System.out.println("Number " + numberOriginal + " is a palindrome number.");
        return reverse == numberOriginal;

    }


}
