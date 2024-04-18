package com.example.demo_gui.utils;

public class calculator {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) throws ArithmeticException{
        if (b == 0){
            throw new ArithmeticException("Can't divide zero");
        }
        return a / b;
    }
}
