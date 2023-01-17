package org.siit.homework.week1;

public class MaxDigit {
    // Display the max digit of a number //
    int numberInitial = -4735;
    int numberToUse = numberInitial;

    public void maxDigit() {
        if (numberToUse < 0) {
            numberToUse = numberToUse * (-1);
        }
        int num = numberToUse;
        int maximum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            maximum = Math.max(lastDigit, maximum);
            num = num / 10;

        }
        System.out.println("Maximum digit of number " + numberInitial + " is " + maximum);


    }

}
