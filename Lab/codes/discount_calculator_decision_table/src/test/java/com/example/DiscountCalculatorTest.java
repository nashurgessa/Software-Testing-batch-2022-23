package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    @Test
    public void testCase3() {

        // Arrange
        // Act
        double obtainedResult = DiscountCalculator.
                calculateDiscount(true, false, true);

        // Assert
        Assertions.assertEquals(20, obtainedResult, "Rule #3");

    }
}
