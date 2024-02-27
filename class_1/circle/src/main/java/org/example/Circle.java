package org.example;

public class Circle {

    private double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // getter
    public double getRadius() {
        return radius;
    }

    // setter
    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        return 2*3.14*this.radius;
    }

    public double getArea() {
      return 3.14* this.radius * this.radius;
    }
}
