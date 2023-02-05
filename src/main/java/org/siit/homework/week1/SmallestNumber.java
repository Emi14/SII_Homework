package org.siit.homework.week1;

import java.util.Arrays;

public class SmallestNumber {
    // Display the smallest number from an array of numbers //

    public void smallestNumber() {
        int[] arr = {4, 3, 5, 8, 2};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min)
                min = arr[i];

        }
        System.out.println("Smallest number in the array " + Arrays.toString(arr) + " is " + min);


    }
}

