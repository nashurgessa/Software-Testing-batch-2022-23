package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {
	
	@Test
	public void NotQuadraticEquation(){
		// Arrange
		QuadraticEquation quEquation = new QuadraticEquation(0, 50, 50);

		//Act
		String result = quEquation.getRoot();

		// Assert
		assertEquals("Not a quadratic equation", result, "The result must be not an equation");
	}
}
