package com.example.demo_gui.controller;

import com.example.demo_gui.service.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import com.example.demo_gui.common.RegistrationResult;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationControllerTest {
    static RegistrationController regController;
    @BeforeAll
    static void setUp() {
        regController = new RegistrationController();
        System.out.println("BeforeAll is called");
    }
    @BeforeEach
    void setUp2() {
        System.out.println("BeforeEach is called");
    }

    @AfterEach
    void tearDown2() {
        System.out.println("AfterEach is called");
    }

    @Test
    void TC1(){
        RegistrationResult regResult =
                regController.attemptRegistration("Allen",
                        "example@gmail.com",
                        "Password123$",
                        "Password123$"
                );

        assertEquals(RegistrationResult.SUCCESS, regResult);
    }
    @Test
    void TC2(){
        RegistrationResult regResult =
                regController.attemptRegistration("Allen",
                        "example@gmail.com",
                        "Password123$",
                        "Password123@"
                );

        assertEquals(RegistrationResult.PASSWORD_MISMATCH, regResult);
    }
    @Test
    void TC3(){
        RegistrationResult regResult =
                regController.attemptRegistration("Allen",
                        "examplegmail.com",
                        "Password123$",
                        "Password123$"
                );

        assertEquals(RegistrationResult.REGISTRATION_FAILED, regResult);
    }
    @Test
    void TC4(){
        RegistrationResult regResult =
                regController.attemptRegistration("Allen",
                        "example@gmailcom",
                        "Password123$",
                        "Password123$"
                );

        assertEquals(RegistrationResult.REGISTRATION_FAILED, regResult);
    }
    @Test
    void TC5(){
        RegistrationResult regResult =
                regController.attemptRegistration("Allen",
                        "example@gmail.com",
                        "Password123",
                        "Password123"
                );

        assertEquals(RegistrationResult.REGISTRATION_FAILED, regResult);
    }

    @Test
    void TC6(){
        RegistrationResult regResult =
                regController.attemptRegistration(null,
                        "example@gmail.com",
                        "Password123",
                        "Password123"
                );

        assertEquals(RegistrationResult.REGISTRATION_FAILED, regResult);
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Afterall is Called");
    }

    /*
     UserService userService = new UserService();
    // UserService userService = UserService.getInstance();
    private RegistrationController regController;

    @BeforeEach
    void setUp(){
        regController = new RegistrationController();
    }


    @Test
    @Disabled
    void attemptRegistrationTest() {
        String name="nashu";
        String email = "naurgessa@gmail.com";
        String password = "Password123@";
        String confirmPassword = "Password123@";

        // RegistrationResult result = regController.attemptRegistration(name, email, password, confirmPassword);
        // assertEquals(RegistrationResult.SUCCESS, result, "The result is not equal");
    }



//    private static Stream<Arguments> provideRegistrationCases() {
//        return Stream.of(
//                Arguments.of("nashu", "naurgessa@gmail.com", "Password123@", "Password123@",RegistrationResult.SUCCESS),
//                Arguments.of("nashu", "naurgessa@gmail.com", "password123@", "Password12@3", RegistrationResult.PASSWORD_MISMATCH),
//                Arguments.of(null, "naurgessa@gmail.com" ,"Password123@" ,"Password123@", RegistrationResult.REGISTRATION_FAILED),
//                Arguments.of("nashu", "naurgessagmail.com", "Password123@", "Password123@", RegistrationResult.REGISTRATION_FAILED),
//                Arguments.of("nashu", "naurgessa@gmail.com","password12","password12", RegistrationResult.REGISTRATION_FAILED),
//                Arguments.of("nashu","" ,"Password123@","Password123@", RegistrationResult.REGISTRATION_FAILED),
//                Arguments.of("nashu", "naurgess@gmail.com", "Password123@", "Password123@",RegistrationResult.SUCCESS)
//        );
//    }

//    @ParameterizedTest
//    @MethodSource("provideRegistrationCases")
//    public void testattemptRegistrationTest(String name, String email, String password, String confirmPassword, RegistrationResult result){
//        // assertEquals(regController.attemptRegistration(name, email, password, confirmPassword), result, "Failed");
//    }

*/
}
