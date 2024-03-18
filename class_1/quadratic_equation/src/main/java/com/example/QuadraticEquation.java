package com.example;

public class QuadraticEquation {
	private double a;
    private double b;
    private double c;
    private boolean isValid;


    public QuadraticEquation(double a, double b, double c){
        this.isValid = a < 0 || a > 100 || b< 0 || b> 100 || c< 0 || c > 100;

        this.a = a;
        this.b = b;
        this.c = c;


    }

    public double discriminant() {
        return b * b  -  4 * a * c;
    }

    public String getRoot() {
        if (isValid) {
            return "Invalid Input";
        }

        if (a == 0) {
            return "Not a quadratic equation";
        }

        double d = discriminant();

        if (d < 0) return "Imaginary root";
        else if (d ==0) return "Equal Root";
        else return "Two Roots";
    }
}
