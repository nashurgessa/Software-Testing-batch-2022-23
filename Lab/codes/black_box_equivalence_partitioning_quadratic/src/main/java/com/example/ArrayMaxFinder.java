package com.example;

public class ArrayMaxFinder {
    public int findMaxValue(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException
                    ("Array must not be null or empty");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
