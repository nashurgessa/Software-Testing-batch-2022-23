package org.example.todo_demo.utils;

public class LinearSearch {
    public static int checkedSearch(int[] a, int x) {
        // Check for null or empty array
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Null or empty array.");
        }

        // Linear search for the value x
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i; // Value found, return index
            }
        }

        // Value not found
        return -1;
    }
}
