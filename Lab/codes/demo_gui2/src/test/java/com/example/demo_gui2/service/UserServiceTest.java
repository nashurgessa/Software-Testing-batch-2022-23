package com.example.demo_gui2.service;

import com.example.demo_gui2.Service.UserService;
import com.example.demo_gui2.common.HttpBackendConnector;
import com.sun.jdi.connect.Connector;
import kotlin.ParameterName;
import okhttp3.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @Mock
    private HttpBackendConnector http;
    @Mock
    Response response;
    private UserService userService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = UserService.getInstance();
        // stub, injection
        userService.http = http;
    }
    @Test
    void testRegisterUserSuccess() throws IOException {
        // Setup the mock behavior
        when(http.sendPost(anyString(),
                eq("register"))).
                thenReturn(response);

        when(response.code()).thenReturn(200);

        boolean result = userService.registerUser("Alice",
                "alice@example.com", "Password123@");
        // Assert
        assertTrue(result);

    /*
    static UserService userService;
    @BeforeEach // @BeforeEach
    void setUp() {
        userService = UserService.getInstance();
    }
    @Test
    void registerTest() throws IOException {
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
}
