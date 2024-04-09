package org.example.todo_demo.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private static UserService userService;

//    @BeforeAll
//    static void setUp() {
//        userService = UserService.getInstance();
//        System.out.println("BeforeAll is called");
//    }
//
//    @AfterEach
//    void testingBeforeEach() {
//        userService = null;
//        System.out.println("After Each is called");
//    }
//
//    @BeforeEach
//    void testingAfterEach() {
//        userService = UserService.getInstance();
//        System.out.println("Before Each is called");
//    }

    @Test
    void testPasswordJustBelowLowerBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "12345"));
    }

    @Test
    void testPasswordAtLowerBoundary() {
        assertFalse(userService.registerUser("John Doe", "john@example.com", "123456"));
    }

    @Test
    void practice() {


    }

//    @ParameterizedTest
//    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
//    void palindromes(String candidate) {
//        assertTrue(StringUtils.isPalindrome(candidate));
//    }
}
