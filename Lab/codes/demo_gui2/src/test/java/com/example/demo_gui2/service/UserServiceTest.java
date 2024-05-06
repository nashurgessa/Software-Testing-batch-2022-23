package com.example.demo_gui2.service;

import com.example.demo_gui2.Service.UserService;
import com.sun.jdi.connect.Connector;
import kotlin.ParameterName;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    static UserService userService;
    @BeforeEach // @BeforeEach
    void setUp() {
        userService = UserService.getInstance();
    }
    @Test
    void registerTest() {
        boolean registResult = userService.registerUser(
                "ABC", "example@gmail.com",
                "Password123@"
        );

        assertTrue(registResult);
    }
    @Test
    void testLogin() {
        assertTrue(userService.login("example@gmail.com",
                "Password123@"));
    }

    /*
    @BeforeEach
    void beforeEachMethod() {
        System.out.println("This is before Each");
    }
    @AfterEach
    void afterEachMethod() {
        System.out.println("This is After Each");
    }
    // @Disabled
    @Disabled
    @Test
    void testLogin(){
        assertAll("Checking Login",
                ()-> assertTrue(userService.login("user@example.com", "password")),
                ()-> assertFalse(userService.login("admin@example.com", "password")),
                ()-> assertFalse(userService.login("user@example.com", "password1"))
        );
    }
    @Test
    void registerUserTest() {
        // Name, email, password
        assertTrue(userService.registerUser("Alex", "abcd@example.com", "Password123@"));
    }

    */
}
