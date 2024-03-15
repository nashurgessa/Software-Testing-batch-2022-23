package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            double jojo = divide(3, 0);
            System.out.println("Jojo result is : "+ jojo);
        } catch(Exception edward) {
            edward.printStackTrace();
        }
    }

    public static double divide(double a, double b) {
        return a / b;
    }
}