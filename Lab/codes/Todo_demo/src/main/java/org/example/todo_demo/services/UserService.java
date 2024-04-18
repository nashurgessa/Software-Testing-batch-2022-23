package org.example.todo_demo.services;

import okhttp3.Response;
import org.example.todo_demo.common.HttpBackendConnector;
import org.example.todo_demo.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users = new HashMap<>();
    HttpBackendConnector http = HttpBackendConnector.getInstance();

    // Singleton
    private static UserService instance;

    /**
     * Private constructor to prevent instantiation outside the class.
     */
    private UserService() {}

    /**
     * Returns the single instance of UserService, creating it if it does not already exist.
     * @return The singleton UserService instance.
     */
    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    // Singleton Finished

    /**
     * Registers a new user if they do not already exist.
     * @param name The user's name.
     * @param email The user's email, which serves as a unique identifier.
     * @param password The user's password.
     * @return true if the user was successfully registered, false if the user already exists.
     */
    public boolean registerUser(String name, String email, String password) {
        System.out.println();

        // Check if user already exists
        if (users.containsKey(email)) {
            // User already exists
            return false;
        }

        // Create and store the new user
        User newUser = new User(name, email, password);
        // TODO: ONLY USE IT IN DEVELOPMENT
        System.out.println("The user saved information is: " + newUser.toString());

        // Instead of this save iot to local Database
        users.put(email, newUser);

        // Save to server as well
        Boolean success = RegisterToServer(newUser);

        // add
        return success;
    }

    /**
     * Sends user data to a remote server.
     * @param user The user whose data is to be sent.
     * @return true if the server acknowledged the data, false otherwise.
     */
    public boolean RegisterToServer(User user) {
        // Todo, saving to Local database

        // get the json format of user format
        String jsonPayload = user.getJson();

        Response jsonResponse = http.sendPost(jsonPayload, "register");

        if (jsonResponse.code() == 200) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * Validates user login credentials.
     * @param email The user's email.
     * @param password The user's password.
     * @return true if the credentials are valid, false otherwise.
     */
    public boolean login1(String email, String password) {
        User user = users.get(email);
        // TODO: ONLY USE IT IN DEVELOPMENT
        System.out.println("correct email: " + user.getEmail() + " | user prompt email: " +email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Login successful
        }
        return false; // Login failed
    }

    /**
     * A simplified login method used for demonstration. Always returns true for specific credentials.
     * @param email The user's email.
     * @param password The user's password.
     * @return true if the credentials match "user" and "password", false otherwise.
     */
    public boolean login(String email, String password) {
        return "user".equals(email) && "password".equals(password);
    }

}
