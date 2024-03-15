package com.example;

public class QuadraticEquation {

	private double a, b, c;
	private boolean isValid;

	public QuadraticEquation(double a, double b, double c) throws IllegalArgumentException{

		// if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
		// 	throw new IllegalArgumentException("The input must be in the range [0, 100]");
		// }
		this.isValid = a >= 0 && a <= 100 && b >= 0 && b <= 100 && c >= 0 && c <= 100;

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

		// check if the inputs are valid / not
		if (!isValid) {
			return "Invalid input, the input raange must be within [1, 100]";
		}

		double delta = discriminant();

		// if (delta > 0) {
		// 	return "Two distinct real roots";
		// } else if (delta == 0) {
		// 	return "One real root, repeated";
		// } else {
		// 	return "Imaginary roots";
		// }
		if ( delta >= 0) {
			return "Real root";
		} else {
			return "Imaginary roots";
		}
	}


}
