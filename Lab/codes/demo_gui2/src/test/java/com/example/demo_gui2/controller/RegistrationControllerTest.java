package com.example.demo_gui2.controller;

import com.example.demo_gui2.common.RegistrationResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationControllerTest {
    static RegistrationController regController;
    @Disabled
    @BeforeAll
    static void setUp(){
        regController = new RegistrationController();
    }
    @Disabled
    @Test
    void test1() {
        RegistrationResult result = regController.attemptRegistration(
                "Allen", "example@gmail.com",
                "Password123@", "Password123@");
        /*
        result = SUCCESS, REGISTRATION_FAILED, PASSWORD_MISMATCH
         */
        assertEquals(RegistrationResult.SUCCESS, result);
    }
    @Disabled
    @Test
    void test2() {
        RegistrationResult result = regController.attemptRegistration(
                "Allen", "example@gmail.com",
                "Password123@", "Password123$");
        /*
        result = SUCCESS, REGISTRATION_FAILED, PASSWORD_MISMATCH
         */
        assertEquals(RegistrationResult.PASSWORD_MISMATCH, result);
    }
    @Disabled
    @Test
    void test3() {
        RegistrationResult result = regController.attemptRegistration(
                "Allen", "examplegmail.com",
                "Password123@", "Password123@");
        /*
        result = SUCCESS, REGISTRATION_FAILED, PASSWORD_MISMATCH
         */
        assertEquals(RegistrationResult.REGISTRATION_FAILED, result);
    }
    @Disabled
    @Test
    void test4() {

    }
    @Disabled
    @Test
    void test5() {

    }


    //@ParameterizedTest
    //@ValueSource(strings = {"Neusoft", "JUnit"})
    //void withValueSource(String argument) {
    //    System.out.println("The argument is : "+ argument);
    //    assertNotNull(argument);
    //}

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, false"})
    void withoutCSVFile(int a, boolean b) {
        assertEquals(b, a < 3);
    }

    @ParameterizedTest
    @CsvFileSource(resources="/input.csv",numLinesToSkip=1)
    void withCSResourceFile(int number, boolean expected){
        assertEquals(expected, number < 3);
    }

    static Stream<String> methodProvider() {
        return Stream.of("apple", "banana");
    }

    @ParameterizedTest
    @MethodSource("methodProvider")
    void testCase(String fruits) {
        System.out.println("Fruits: " + fruits);
        assertNotNull(fruits);
    }

    static Stream<Object[]> data() {
        return Stream.of(
             new Object[] {1, 2},
                new Object[]{2, 3}
        );
    }
    @ParameterizedTest
    @MethodSource("data")
    void testArray(int a, int b) {
        System.out.println(a);
        assertNotNull(a);
    }

}
