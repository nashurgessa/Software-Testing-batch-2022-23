package org.example;

public class Rectangle {

    public static double getAreaOfRectangle(double width,
                                            double length) {

        if(width <= 0 || length <= 0){
            throw new IllegalArgumentException(
                    "Width & Length must be a +ve #");
        }

        return width * length;
    }
}
