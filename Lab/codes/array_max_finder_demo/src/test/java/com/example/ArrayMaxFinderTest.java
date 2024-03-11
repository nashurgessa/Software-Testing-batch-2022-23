package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMaxFinderTest {

    @Test
    public void testFindMaxValueNormalCase() {
        int[] array = {1, 3, 5, 7, 9};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertEquals(9, finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueWithSingleElement() {
        int[] array = {42};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertEquals(42, finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueWithNegativeValues() {
        int[] array = {-10, -3, -5, -7, -9};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertEquals(-3, finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueWithMixedValues() {
        int[] array = {-1, 0, 3, -2, 5};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertEquals(5, finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueWithIdenticalElements() {
        int[] array = {7, 7, 7, 7, 7};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertEquals(7, finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueThrowsExceptionForEmptyArray() {
        int[] array = {};
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertThrows(IllegalArgumentException.class, () -> finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueThrowsExceptionForNullArray() {
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertThrows(IllegalArgumentException.class, () -> finder.findMaxValue(null));
    }
}
