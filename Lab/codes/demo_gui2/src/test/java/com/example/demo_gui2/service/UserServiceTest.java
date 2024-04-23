package com.example.demo_gui2.service;

import com.example.demo_gui2.Service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    static UserService userService;

    @BeforeAll
    static void setUp() {
        userService = new UserService();
    }
    @BeforeEach
    void beforeEachMethod() {
        System.out.println("This is before Each");
    }
    @AfterEach
    void afterEachMethod() {
        System.out.println("This is After Each");
    }
    // @Disabled
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
}
