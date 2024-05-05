package com.example.demo_gui.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailPasswordValidatorTest {
    static EmailPasswordValidator validator;
    @BeforeAll
    static void setUP() {
        validator = new EmailPasswordValidator();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/password_inputs.csv", numLinesToSkip = 1)
    void testBVAPassword(String password, boolean expected) {
        assertEquals(expected, validator.isPasswordValid(password));
    }

    /*
    EmailPasswordValidator validator = new EmailPasswordValidator();

    @Test
    void testEmailValidator(){
        assertAll("EmailValidator",
                () -> assertTrue(validator.isEmailValid("example@gmail.com")),
                () -> assertFalse(validator.isEmailValid("examplegmail.com")),
                () -> assertFalse(validator.isEmailValid("example@gmailcom")),
                () -> assertFalse(validator.isEmailValid("exa$mple@gmail.com")));
    }

    @Test
    void testPasswordBVAApproach() {
        // {6, 24}, [5, 6, 7, 23, 24, 25]

    }

     */
}
