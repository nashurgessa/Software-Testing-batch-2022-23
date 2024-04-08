package org.example.todo_demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    private static UserService userService;

    @BeforeAll
    static void setUp() {
        userService = UserService.getInstance();
        System.out.println("BeforeAll is called");
    }

    @AfterEach
    void testingBeforeEach() {
        userService = null;
        System.out.println("After Each is called");
    }

    @BeforeEach
    void testingAfterEach() {
        userService = UserService.getInstance();
        System.out.println("Before Each is called");
    }

    @Test
    void testPasswordJustBelowLowerBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "12345"));
    }

    @Test
    void testPasswordAtLowerBoundary() {
        assertFalse(userService.registerUser("John Doe", "john@example.com", "123456"));
    }
}
