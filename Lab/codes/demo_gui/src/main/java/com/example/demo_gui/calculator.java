package com.example.demo_gui;

public class calculator {

    public static int add(int a, int b){
        return a + b;
    }

    public static int checkedSearch(int[] a, int x) {
        if (a == null || a.length == 0)
            throw new IllegalArgumentException("Null or empty array.");
        return -1;
    }

}
