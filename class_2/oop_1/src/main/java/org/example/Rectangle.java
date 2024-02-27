package org.example;

public class Rectangle {
    private double height;
    double width;

    // Constructor
    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    void setHeight(double height) {
        this.height = height;
    }

    double getHeight() {
        return this.height;
    }

    double getPerimeter() {
        return 2*this.height + 2* this.width;
    }

    double getArea() {
        return this.height * this.width;
    }
}
