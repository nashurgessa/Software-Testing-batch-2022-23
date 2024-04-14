package org.example.todo_demo.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    /*
    private static UserService service = new UserService(); // Assume this service handles login logic

    @Test
    void testAllowLogin() {
        // R1: All conditions are true
        assertTrue(service.login("example@yahoo.com", "Password123@"),
                "Should allow login when username exists, password is valid, and matches.");
    }

    @Test
    void testRejectLoginEmptyUsername() {
        // R2: Username not empty is false
        assertFalse(service.login("", "Password123@"),
                "Should reject login when username is empty.");
    }

    @Test
    void testRejectLoginUsernameDoesNotExist() {
        // R3: Username exists in the database is false
        assertFalse(service.login("example$yahoo.com", "password123@"),
                "Should reject login when username does not exist.");
    }

    @Test
    void testRejectLoginInvalidPassword() {
        // R4: Password valid is false
        assertFalse(service.login("example@yahoo.com", "pard1@"),
                "Should reject login when password is invalid.");
    }

    @Test
    void testRejectLoginPasswordDoesNotMatch() {
        // R5: Password matches the database for the user is false
        assertFalse(service.login("validUser", "wrongPassword"),
                "Should reject login when password does not match.");
    }
    */


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
