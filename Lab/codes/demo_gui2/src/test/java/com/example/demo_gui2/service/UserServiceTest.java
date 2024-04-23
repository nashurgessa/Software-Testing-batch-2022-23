package com.example.demo_gui2.service;

import com.example.demo_gui2.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    void testLogin(){
        assertAll("Checking Login",
                ()-> assertTrue(userService.login("user@example.com", "password")),
                ()-> assertFalse(userService.login("admin@example.com", "password")),
                ()-> assertFalse(userService.login("user@example.com", "password1"))
        );
    }


}
