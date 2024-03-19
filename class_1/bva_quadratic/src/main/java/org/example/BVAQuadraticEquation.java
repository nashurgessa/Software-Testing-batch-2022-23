package org.example;

public class BVAQuadraticEquation {

    private double a, b, c;

    // Constructor

    public BVAQuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public  double discriminant() {
        return b*b - 4*a*c;
    }

    public String getRoot() {

        if (a == 0) {
            return "Not a quadratic Equation";
        }

        double d = discriminant();

        if (d > 0) return "Real root";
        else if(d == 0) return "Equal root";
        else return "Imaginary root";
    }
}
