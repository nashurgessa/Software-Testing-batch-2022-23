package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Normal Case
        try {
            double area1 = Rectangle.getAreaOfRectangle(3,
                    2);
            System.out.println("The area is : " + area1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // -ve Case
        try {
            double area1 = Rectangle.getAreaOfRectangle(-3,
                    2);
            System.out.println("The area is : " + area1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}