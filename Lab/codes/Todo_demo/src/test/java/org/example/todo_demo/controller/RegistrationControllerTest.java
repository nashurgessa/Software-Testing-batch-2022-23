package org.example.todo_demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvFileSource;

public class RegistrationControllerTest {

    /*
    private final RegistrationController registrationController = new RegistrationController() ;

    @Test
    void testPasswordJustBelowLowerBoundary() {
        // This should fail because it's too short and doesn't meet other criteria
        assertFalse(registrationController.isValidPassword("Aa@5"));
    }

    @Test
    void testPasswordAtLowerBoundary() {
        // This meets all criteria, including length
        assertTrue(registrationController.isValidPassword("Aa@12345"));
    }

    @Test
    void testPasswordJustAboveLowerBoundary() {
        // This meets all criteria, including length
        assertTrue(registrationController.isValidPassword("Aa@123456"));
    }

    @Test
    void testPasswordJustBelowUpperBoundary() {
        // Construct a password that's 23 characters long and meets all criteria
        assertTrue(registrationController.isValidPassword("Aa@1234567890123456789"));
    }

    @Test
    void testPasswordAtUpperBoundary() {
        // Construct a password that's 24 characters long and meets all criteria
        assertTrue(registrationController.isValidPassword("Aa@12345678901234567890"));
    }

    @Test
    void testPasswordJustAboveUpperBoundary() {
        // This should fail because it's too long
        assertFalse(registrationController.isValidPassword("Aa@12345678901234567890a1"));
    }
    */


    private static RegistrationController registrationController;
    @BeforeAll
    static void setUp(){
        registrationController = new RegistrationController();
        System.out.println("Before all called");
    }

    /*
    @ParameterizedTest
    @CsvSource({
            "Aa@5, false", // Just below lower boundary
            "Aa@12345, true", // At lower boundary
            "Aa@123456, true", // Just above lower boundary
            "Aa@1234567890123456789, true", // Just below upper boundary
            "Aa@12345678901234567890, true", // At upper boundary
            "Aa@Aa@12345678901234567890a1, false" // Just above upper boundary
    })
    void testPasswordValidation(String password, boolean expectedOutcome) {
        Assertions.assertEquals(expectedOutcome, registrationController.isValidPassword(password),
                "Failed for password: " + password);
    }
    */

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_password_length_tester.csv", numLinesToSkip = 1) // Skip header row
    void testPasswordValidation(String password, boolean expectedOutcome) {
        Assertions.assertEquals(expectedOutcome, registrationController.isValidPassword(password),
                "Failed for password: " + password);
    }

}
