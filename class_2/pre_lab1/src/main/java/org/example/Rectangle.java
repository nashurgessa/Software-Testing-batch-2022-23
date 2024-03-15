package org.example;

public class Rectangle {

    public static double getArea(double width, double length) {

        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException(
                    "The w & l must be greater 0");
        }

        return width * length;
    }

}
