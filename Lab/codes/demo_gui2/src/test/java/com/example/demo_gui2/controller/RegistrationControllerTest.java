package com.example.demo_gui2.controller;

import com.example.demo_gui2.common.RegistrationResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationControllerTest {
    static RegistrationController regController;
    @BeforeAll
    static void setUp(){
        regController = new RegistrationController();
    }
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

    }

    @Disabled
    @Test
    void test4() {

    }

    @Disabled
    @Test
    void test5() {

    }
}
