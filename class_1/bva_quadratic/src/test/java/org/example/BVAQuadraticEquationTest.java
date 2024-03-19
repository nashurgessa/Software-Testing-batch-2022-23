package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class BVAQuadraticEquationTest {
    @Test
    public void notQuadraticEquation() {
        // Arrange
        BVAQuadraticEquation quad =
                new BVAQuadraticEquation(0, 50, 50);
        // Act
        String obtainedResult = quad.getRoot();
        // Assert
        // Assertions.assertEquals(Expected, Obtained, Message);
        Assertions.assertEquals("Not a quadratic Equation",
                obtainedResult, "Hello Class 1");
    }

    @Test
    public void realRootEquation() {
        // Arrange
        BVAQuadraticEquation quad =
                new BVAQuadraticEquation(1, 50, 50);
        // Act
        String obtainedResult = quad.getRoot();
        // Assert
        // Assertions.assertEquals(Expected, Obtained, Message);
        Assertions.assertEquals("Real root",
                obtainedResult, "Hello Class 1");
    }
}
