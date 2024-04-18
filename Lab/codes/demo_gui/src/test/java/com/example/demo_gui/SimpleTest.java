package com.example.demo_gui;


import com.example.demo_gui.utils.LinearSearch;
import com.example.demo_gui.utils.calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    void abc() {
        assertEquals(2, 2);
    }

    @Test
    void abd() {
        assertNotNull(new Object());
    }

    @Test
    void abe() {
        assertNull(null);
    }

    @Test
    void testByGroup() {
        assertAll("Multiple assertions",
                () -> assertEquals(4,
                        calculator.multiply(2, 2)),
                () -> assertThrows(ArithmeticException.class,
                        () -> calculator.divide(1, 0),
                        "Division by zero should result in zero"));
    }


}
