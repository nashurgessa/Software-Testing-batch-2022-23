package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {

	@Test
	public void testRealRoot() {
		// Arrange, 
		QuadraticEquation equation = new QuadraticEquation(1, 50, 50);
		
		// Act  
		String result = equation.classifyRoots();
		
		// Assert
		assertEquals("Real root", result);
	}

	@Test
	public void testImaginaryRoot() {
		// Arrange, 
		QuadraticEquation equation = new QuadraticEquation(50, 50, 50);
		
		// Act  
		String result = equation.classifyRoots();
		
		// Assert
		assertEquals("Imaginary roots", result);
	}

	@Test
	public void testNotAQuadraticEquation() {
		// Arrange, 
		QuadraticEquation equation = new QuadraticEquation(0, 50, 50);
		
		// Act  
		String result = equation.classifyRoots();
		
		// Assert
		assertEquals("Not a quadratic equation", result);
	}

	@Test
	public void testInvalidInput1() {
		// Arrange, 
		QuadraticEquation equation = new QuadraticEquation(-1, 50, 50);
		
		// Act  
		String result = equation.classifyRoots();
		
		// Assert
		assertEquals("Invalid input, the input raange must be within [1, 100]", result);
	}

	@Test
	public void testInvalidInput2() {
		// Arrange, 
		QuadraticEquation equation = new QuadraticEquation(101, 50, 50);
		
		// Act  
		String result = equation.classifyRoots();
		
		// Assert
		assertEquals("Invalid input, the input raange must be within [1, 100]", result);
	}

	// Continue for the remaining cases
}
