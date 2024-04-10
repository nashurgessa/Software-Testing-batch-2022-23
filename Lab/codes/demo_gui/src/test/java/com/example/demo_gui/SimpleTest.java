package com.example.demo_gui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {

    @Test
    void summationTwoNumber(){
        assertEquals(4, calculator.add(2, 2));
    }
}
