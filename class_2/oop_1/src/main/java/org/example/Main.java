package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle(3, 5);

        Rectangle rect2 = new Rectangle(5, 4);

        // rect1.height = 10;
        rect1.setHeight(10);

        // rectangle 1
        System.out.println("The perimeter is : " + rect1.getPerimeter() +
                " The area is : " + rect1.getArea());

    }
}