package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMaxFinderTest {

    ArrayMaxFinder maxValue = new ArrayMaxFinder();

    @Test
    public void testCase1() {
        //A, Arrange
        int[] t1_input = {1, 2, 3, 4, 3};
        // A, Act
        int max_returned_value = maxValue.findMaxValue(t1_input);
        // A, Assert
        Assertions.assertEquals(4, max_returned_value, "TC1");
    }

    @Test
    public void testCase2() {
        //A, Arrange
        int[] t1_input = {3};
        // A, Act
        int max_returned_value = maxValue.findMaxValue(t1_input);
        // A, Assert
        Assertions.assertEquals(3, max_returned_value, "TC1");
    }

    @Test
    public void testCase3() {
        //A, Arrange
        int[] t1_input = {0, 1, -1, 2, 4, 3};
        // A, Act
        int max_returned_value = maxValue.findMaxValue(t1_input);
        // A, Assert
        Assertions.assertEquals(4, max_returned_value, "TC1");
    }

    @Test
    public void testCase4() {
        //A, Arrange
        int[] t1_input = {-1, -2, -3, -4, -3};
        // A, Act
        int max_returned_value = maxValue.findMaxValue(t1_input);
        // A, Assert
        Assertions.assertEquals(-1, max_returned_value, "TC4");
    }

    @Test
    public void testCase5() {
        //A, Arrange
        int[] t1_input = {1, 1, 1, 1, 1};
        // A, Act
        int max_returned_value = maxValue.findMaxValue(t1_input);
        // A, Assert
        Assertions.assertEquals(1, max_returned_value, "TC5");
    }

    @Test
    public void testCase6() {
        //A, Arrange
        int[] t1_input = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> maxValue.findMaxValue(t1_input));
    }

    @Test
    public void testCase7() {
        //A, Arrange
        int[] t1_input = {};
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> maxValue.findMaxValue(t1_input));

    }

}