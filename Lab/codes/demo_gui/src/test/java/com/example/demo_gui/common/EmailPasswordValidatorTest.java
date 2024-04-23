package com.example.demo_gui.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailPasswordValidatorTest {
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
}
