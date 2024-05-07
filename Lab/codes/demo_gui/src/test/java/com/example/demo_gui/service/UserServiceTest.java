package com.example.demo_gui.service;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private static UserService userService;
    @BeforeEach
    void setUp() {
        userService = UserService.getInstance();
    }
    @Test
    void testRegistration() {
        boolean regResult = userService.registerUser("Allen", "example@gmail.com",
                "Password123@");
        assertTrue(regResult);
    }
    @Test
    void testLogin() {
        assertTrue(userService.login("example@gmail.com", "Password123@"));
    }
    /*@Test
    void testLogin() {
        assertAll("Testing for login",
                () -> assertTrue(userService.login("user", "password")),
                () -> assertFalse(userService.login("admin", "password")),
                () -> assertFalse(userService.login("user", "Pass"))
                );
    }*/


//    UserService userService = new UserService();
//    // UserService userService = UserService.getInstance();
//
//    @Test
//    @Disabled
//    void testLogin1() {
//        assertAll("Multiple assertions",
//                () ->assertTrue(userService.login("user@example.com", "password")),
//                () -> assertFalse(userService.login("user@example1.com", "password")),
//                () -> assertFalse(userService.login("user@example.com", "password1")),
//                () -> assertFalse(userService.login("user@example1.com", "password1"))
//        );
//    }
//
//    @Test
//    @Disabled
//    void testLogin() {
//        assertAll("Multiple assertions",
//                () ->assertTrue(userService.login("user@gmail.com", "Password123@"), "Case 1"),
//                () -> assertFalse(userService.login("usergmail1.com", "Password123@"), "Case 2"),
//                () -> assertFalse(userService.login("user@gmail.com", "password123@"), "Case 3"),
//                () -> assertFalse(userService.login("usergmailcom", "password1"), "Case 4")
//        );
//    }
//
//    @Test
//    void testEmail() {
//        boolean isValidate  = userService.login("user@gmail.com", "Password123@");
//        assertTrue(isValidate, "Case 11");
//    }


}
