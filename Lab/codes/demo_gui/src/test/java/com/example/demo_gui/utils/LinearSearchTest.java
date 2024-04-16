package com.example.demo_gui.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinearSearchTest {

    LinearSearch search = new LinearSearch();

    @Test
    void abc() {
        int[] array = {1, 5, 3};
        assertTrue(search.checkedSearch(array, 5) >= 0);
        assertFalse(search.checkedSearch(array, 2) >= 0);
    }

//    @Test
//    void abd() {
//        int[] array = {1, 5, 3};
//        int x = 2;
//        // A, act
//
//        // A, assert
//        assertFalse(search.checkedSearch(array, x) >= 0);
//    }

    @Test
    void test2() {
        assertNull(null);  // if it null
        assertNotNull(new Object());
    }

    @Test
    void test3() {
        assertNotSame(new Object(), new Object(), "Should not be same.");

        Integer num1 = Integer.valueOf(2013);
        assertSame(num1, num1, "Should be same.");

        Integer num2 = Integer.valueOf(2014);
        assertNotSame( num1, num2, "Should be same.");
    }

    @Test
    void Test4() {
        int[] a1 = { 2, 3, 5, 7 };
        int[] a2 = { 2, 3, 5, 7 };

        assertArrayEquals(a1, a2, "Should be equal");

        int[][] a11 = { { 2, 3 }, { 5, 7 }, { 11, 13 } };
        int[][] a12 = { { 2, 3 }, { 5, 7 }, { 11, 13 } };
        assertArrayEquals(a11, a12, "Should be equal");
    }

    @Test
    void test5() {
        double d1 = 100.0, d2 = 99.99995;
        assertEquals(d1, d2, 0.0001, "Should be equal within delta.");
        assertEquals(2.0, 2.0009, 0.001, "Hello");
    }

    @Test
    void Test6() {
        assertThrows(IllegalArgumentException.class,
                () -> search.checkedSearch(null, 2));
    }

    @Test
    void Test7() {
        int[] array = {};

        assertThrows(IllegalArgumentException.class,
                () -> search.checkedSearch(array, 2));
    }

}
