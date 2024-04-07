package org.example.todo_demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = UserService.getInstance();
    }

    @Test
    void testPasswordJustBelowLowerBoundary() {
        assertFalse(userService.registerUser("John Doe", "john@example.com", "12345"));
    }

    @Test
    void testPasswordAtLowerBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "123456"));
    }

    @Test
    void testPasswordJustAboveLowerBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "1234567"));
    }

    @Test
    void testPasswordJustBelowUpperBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "123456789012345"));
    }

    @Test
    void testPasswordAtUpperBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "1234567890123456"));
    }

    @Test
    void testPasswordJustAboveUpperBoundary() {
        assertFalse(userService.registerUser("John Doe", "john@example.com", "12345678901234567"));
    }
}
