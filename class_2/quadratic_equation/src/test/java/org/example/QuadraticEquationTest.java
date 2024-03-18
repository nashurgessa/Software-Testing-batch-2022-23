package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadraticEquationTest {

    @Test
    public void inValidInput() {

        // Arrange
        QuadraticEquation quadEquation =
                new QuadraticEquation(-1, 50, 50);

        // Act
        String result = quadEquation.getRoot();

        // Assert
        Assertions.assertEquals("Invalid input",
                result, "Any message");
    }

    @Test
    public void notQuadraticEquation() {

        // Arrange
        QuadraticEquation quadEquation =
                new QuadraticEquation(0, 50, 50);

        // Act
        String result = quadEquation.getRoot();

        // Assert
        Assertions.assertEquals("Not a Quadratic Equation",
                result, "Any message");

    }
}
