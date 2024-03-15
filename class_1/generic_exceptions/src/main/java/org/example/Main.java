package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            double allen = add(4, 0);
            System.out.println("The result from Allen: "+ allen);
        } catch (Exception wilson) {
            System.out.println("Error: "+ wilson.getMessage());
            // wilson.printStackTrace();
        }
    }

    public static int add(int dividend, int divisor) {
        return dividend / divisor;
    }
}