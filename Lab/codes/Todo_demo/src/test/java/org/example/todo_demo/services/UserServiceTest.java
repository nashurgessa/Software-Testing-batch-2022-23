package org.example.todo_demo.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.Response;
import org.example.todo_demo.common.HttpBackendConnector;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    /*
    private static UserService service = new UserService(); // Assume this service handles login logic

    @Test
    void testAllowLogin() {
        // R1: All conditions are true
        assertTrue(service.login("example@yahoo.com", "Password123@"),
                "Should allow login when username exists, password is valid, and matches.");
    }

    @Test
    void testRejectLoginEmptyUsername() {
        // R2: Username not empty is false
        assertFalse(service.login("", "Password123@"),
                "Should reject login when username is empty.");
    }

    @Test
    void testRejectLoginUsernameDoesNotExist() {
        // R3: Username exists in the database is false
        assertFalse(service.login("example$yahoo.com", "password123@"),
                "Should reject login when username does not exist.");
    }

    @Test
    void testRejectLoginInvalidPassword() {
        // R4: Password valid is false
        assertFalse(service.login("example@yahoo.com", "pard1@"),
                "Should reject login when password is invalid.");
    }

    @Test
    void testRejectLoginPasswordDoesNotMatch() {
        // R5: Password matches the database for the user is false
        assertFalse(service.login("validUser", "wrongPassword"),
                "Should reject login when password does not match.");
    }
    */


    // private static UserService userService;

//    @BeforeAll
//    static void setUp() {
//        userService = UserService.getInstance();
//        System.out.println("BeforeAll is called");
//    }
//
//    @AfterEach
//    void testingBeforeEach() {
//        userService = null;
//        System.out.println("After Each is called");
//    }
//
//    @BeforeEach
//    void testingAfterEach() {
//        userService = UserService.getInstance();
//        System.out.println("Before Each is called");
//    }

    /*@Test
    void testPasswordJustBelowLowerBoundary() {
        assertTrue(userService.registerUser("John Doe", "john@example.com", "12345"));
    }

    @Test
    void testPasswordAtLowerBoundary() {
        assertFalse(userService.registerUser("John Doe", "john@example.com", "123456"));
    }

    @Test
    void practice() {
        // ...
    }*/

//    @ParameterizedTest
//    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
//    void palindromes(String candidate) {
//        assertTrue(StringUtils.isPalindrome(candidate));
//    }


    @Mock
    private HttpBackendConnector http;

    @Mock
    private Response response;
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        userService = UserService.getInstance();
        userService.http = http; // Inject the mock HttpBackendConnector
    }

    @Test
    void testRegisterUserSuccess() {
        // Prepare the payload
//        Map<String, String> payload = new HashMap<>();
//        payload.put("name", "Alice");
//        payload.put("email", "alice@example.com");
//        payload.put("password", "pass123");

//        try {
//            // Serialize the payload to JSON
//            ObjectMapper mapper = new ObjectMapper();
//            String jsonPayload = mapper.writeValueAsString(payload);

        // Setup the mock behavior
        when(http.sendPost(anyString(), eq("register"))).thenReturn(response);
        when(response.code()).thenReturn(200);

        // Act
        boolean result = userService.registerUser("Alice", "alice@example.com", "pass123");

        // Assert
        assertTrue(result);

        // verify(http).sendPost(jsonPayload, "register");
//        } catch (IOException e) {
//            fail("Exception thrown during test: " + e.getMessage());
//        }
    }

    @Test
    void testRegisterUserAlreadyExists() {
        when(http.sendPost(anyString(), eq("register"))).thenReturn(response);
        when(response.code()).thenReturn(200);
        userService.registerUser("Bob", "bob@example.com", "pass123"); // Register Bob first

        boolean result = userService.registerUser("Bob", "bob@example.com", "pass123"); // Try to register Bob again
        assertFalse(result);

        // No call should be made if the user already exists
        // verify(http, never()).sendPost(anyString(), eq("register"));
    }

//    @Test
//    void simpleTest() {
//        when(response.body()).thenReturn("Simple Test");
//        assertEquals("Simple Test", response.body());
//    }
//

}
