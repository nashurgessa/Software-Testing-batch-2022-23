package com.example.demo_gui2.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class EmailPasswordValidatorTest {
    static EmailPasswordValidator epValidator;
    @BeforeAll
    static void setUp() {
        epValidator = new EmailPasswordValidator();
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/bva_password_input_output.csv", numLinesToSkip = 1)
    void bvaPasswordValidTester(String input, boolean expected) {
        assertEquals(expected, epValidator.isPasswordValid(input));
    }
}
