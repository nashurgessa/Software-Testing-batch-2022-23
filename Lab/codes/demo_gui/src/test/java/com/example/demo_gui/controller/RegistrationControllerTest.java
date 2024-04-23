package com.example.demo_gui.controller;

import com.example.demo_gui.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RegistrationControllerTest {

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
//                Arguments.of("", "naurgessa@gmail.com" ,"Password123@" ,"Password123@", RegistrationResult.REGISTRATION_FAILED),
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


}
