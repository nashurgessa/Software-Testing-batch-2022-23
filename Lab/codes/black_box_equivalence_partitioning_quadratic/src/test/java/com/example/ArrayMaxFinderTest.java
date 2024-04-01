package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMaxFinderTest {

    ArrayMaxFinder maxFinder = new ArrayMaxFinder();

    @Test
    public void testCase1() {
        // Arrange
        int[] tc1_input = {1, 2, 4, 3};
        // Act
        int result = maxFinder.findMaxValue(tc1_input);
        // Assert
        Assertions.assertEquals(4, result, "TestCase 1");
    }
    @Test
    public void testCase2() {
        // Arrange
        int[] tc2_input = {2, -1, 5, 4};
        // Act
        int result = maxFinder.findMaxValue(tc2_input);
        // Assert
        Assertions.assertEquals(5, result, "TestCase 2");
    }
    @Test
    public void testCase3() {
        // Arrange
        int[] tc3_input = {-2, -2, -1, -3};
        // Act
        int result = maxFinder.findMaxValue(tc3_input);
        // Assert
        Assertions.assertEquals(-1, result, "TestCase 3");
    }
    @Test
    public void testCase4() {
        // Arrange
        int[] tc4_input = {1, 1, 1, 1,};
        // Act
        int result = maxFinder.findMaxValue(tc4_input);
        // Assert
        Assertions.assertEquals(1, result, "TestCase 4");
    }
    @Test
    public void testCase5() {
        // Arrange
        int[] tc5_input = {2};
        // Act
        int result = maxFinder.findMaxValue(tc5_input);
        // Assert
        Assertions.assertEquals(2, result, "TestCase 5");
    }
    @Test
    public void testCase6() {
        // Arrange
        int[] tc6_input = {};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> maxFinder.findMaxValue(tc6_input));

    }
    @Test
    public void testCase7() {
        // Arrange
        int[] tc7_input = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> maxFinder.findMaxValue(tc7_input));
    }
}