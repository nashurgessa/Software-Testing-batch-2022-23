package org.example;

public class QuadraticEquation {
    private double a, b, c;
    boolean isValid;
    public QuadraticEquation(double a, double b, double c) {
        isValid = a >= 0 && a <= 100 && b >= 0 && b <= 100 && c>= 0 && c <=100;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double discriminant(){
        return b*b - 4*a*c;
    }

    public String getRoot() {
        if (!isValid) {
            return "Invalid input";
        }
        if (a == 0) {
            return "Not a Quadratic Equation";
        }
        double d = discriminant();
        if (d < 0) return "Imaginary root";
        else if( d == 0) return "One Root";
        else return "Two Root";
    }
}
