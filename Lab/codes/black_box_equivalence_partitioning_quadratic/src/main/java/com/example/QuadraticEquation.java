package com.example;

public class QuadraticEquation {

	private double a, b, c;

	public QuadraticEquation(double a, double b, double c) throws IllegalArgumentException{

		if (a < 1 || a > 100 || b < 1 || b > 100 || c < 1 || c > 100) {
			throw new IllegalArgumentException("The input must be in the range [1, 100]");
		}

		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double discriminant() {
		return b*b - 4*a*c;
	}

	public String classifyRoots() {

		// check if the equation is not a quadratic equation
		if (a == 0) {
			return "Not a quadratic equation";
		}

		double delta = discriminant();

		if (delta > 0) {
			return "Two distinct real roots";
		} else if (delta == 0) {
			return "One real root, repeated";
		} else {
			return "Two complex roots";
		}
	}


}
