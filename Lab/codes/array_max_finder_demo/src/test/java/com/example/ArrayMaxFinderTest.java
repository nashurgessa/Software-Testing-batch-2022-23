package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayMaxFinderTest {

    @Test
    public void testFindMaxValueNormalCase() {
		// Arrange
        int[] array = {1, 3, 5, 7, 9};
        ArrayMaxFinder finder = new ArrayMaxFinder();
		// Act and Assert
		// assertEquals(expectedResult, actualResult, "The expected result does not match the actual result.");
        // Message (Optional):
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
		/*
		 * The assertThrows method takes two arguments: The first argument is the class of the exception 
		 * expected to be thrown, in this case, IllegalArgumentException.class. 
		 * The second argument is an executable block of code, 
		 * represented as a lambda expression () -> finder.findMaxValue(null), 
		 * which when executed is expected to throw the exception. 
		 * If the executable block does throw the exception of the specified type, the test passes. 
		 * If it does not throw an exception or throws a different type of exception, the test fails.
		 * 
		 * assertThrows 方法接受两个参数：
		 * 1. 第一个参数是预期抛出的异常的类，在这个例子中是 IllegalArgumentException.class。
		 * 2. 第二个参数是一个可执行的代码块，用一个 lambda 表达式 () -> finder.findMaxValue(null) 表示，
		 * 执行这段代码时预期会抛出异常。如果这个可执行的代码块确实抛出了指定类型的异常，则测试通过。
		 * 如果没有抛出异常或抛出了不同类型的异常，则测试
		 */
        Assertions.assertThrows(IllegalArgumentException.class, () -> finder.findMaxValue(array));
    }

    @Test
    public void testFindMaxValueThrowsExceptionForNullArray() {
        ArrayMaxFinder finder = new ArrayMaxFinder();
        Assertions.assertThrows(IllegalArgumentException.class, () -> finder.findMaxValue(null));
    }
}
