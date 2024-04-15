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
    public UserService() {}

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    // Singleton Finished

    // Register a new user, using a Fake
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
        RegisterToServer(newUser);

        // add
        return true;
    }

    //Mocking
    public boolean RegisterToServer(User user) {
        // Todo, saving to Local database

        // get the json format of user format
        String jsonPayload = user.getJson();

        Response jsonResponse = http.sendPost(jsonPayload, "register");

        if (jsonResponse.body() != null) {
            System.out.println(jsonResponse.body().toString());
            return true;
        } else {
            return false;
        }

    }


    // Validate login credentials
    public boolean login1(String email, String password) {
        User user = users.get(email);
        // TODO: ONLY USE IT IN DEVELOPMENT
        System.out.println("correct email: " + user.getEmail() + " | user prompt email: " +email);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Login successful
        }
        return false; // Login failed
    }

    public boolean login(String email, String password) {
        return "user".equals(email) && "password".equals(password);
    }

}
