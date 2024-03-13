package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // case 1:
        try {
            double area1 = Rectangle.getArea(4, 3);
            System.out.println("The area is : " + area1);
        } catch (IllegalArgumentException alen) {
            System.out.println(alen.getMessage());
        }

        // case 2:
        try {
            double area1 = Rectangle.getArea(-4, 3);
            System.out.println("The area is : " + area1);
        } catch (IllegalArgumentException alen) {
            System.out.println(alen.getMessage());
        }


    }
}