package com.example.demo_gui.service;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private static UserService userService;
    @AfterAll
    static void setUp() {
        userService = new UserService();
    }
   // Homework, I will give 10 marks for those students who do the homework.


    @Test
    void testLogin() {
        assertAll("Testing for login",
                () -> assertTrue(userService.login("user", "password")),
                () -> assertFalse(userService.login("admin", "password")),
                () -> assertFalse(userService.login("user", "Pass"))
                );
    }


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
