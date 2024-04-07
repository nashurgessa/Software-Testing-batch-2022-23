package org.example.todo_demo.services;

import org.example.todo_demo.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, User> users = new HashMap<>();

    // Singleton
    private static UserService instance;
    public UserService() {}

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    // Singleton Finished

    // Register a new user
    public boolean registerUser(String name, String email, String password) {
        // Check if user already exists
        if (users.containsKey(email)) {
            // User already exists
            return false;
        }

        // Create and store the new user
        User newUser = new User(name, email, password);
        // TODO: ONLY USE IT IN DEVELOPMENT
        System.out.println("The user saved information is: " + newUser.toString());
        users.put(email, newUser);
        return true;
    }

    // Validate login credentials
    public boolean login(String email, String password) {
        User user = users.get(email);
        // TODO: ONLY USE IT IN DEVELOPMENT
        System.out.println("correct email: " + user.getEmail() + " | user prompt email: " +email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Login successful
        }
        return false; // Login failed
    }

}
