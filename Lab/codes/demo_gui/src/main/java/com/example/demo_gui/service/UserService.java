package com.example.demo_gui.service;

import com.example.demo_gui.common.EmailPasswordValidator;
import com.example.demo_gui.models.User;
import kotlin.jvm.Synchronized;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    // define the User
    private User newUser;
    // Create a fake Map/Dict
    private Map<String, User> users = new HashMap<>();

    // Constructor
    private UserService() {
    }

    // create a singleton instance
    private static UserService instance;

    public static synchronized UserService getInstance() {
       if (instance == null) {
           instance = new UserService();
       }
       return instance;
    }

    EmailPasswordValidator validator = new EmailPasswordValidator();

    public boolean login(String email, String password) {
        // return "user".equals(email) && "password".equals(password);
        System.out.println(users.containsKey("email"));
        if (users.containsKey("email")) {
            User user_ = users.get("email");
            // Checks if the user email and password are matched with the user prompt
            return user_.getEmail().equals(email) && user_.getPassword().equals(password);
        }
        return false;
    }

    public boolean registerUser(String name, String email, String password) {
        // To validate
        boolean validatorResult = validateEmailPassword(email, password);
        if (validatorResult) {
            // Created a new User Object
            newUser = new User(name, email, password);
            // display the new User
            System.out.println("The new User Info, is: "+ newUser.toString());
            // Only a new User will register.
            if (!users.containsKey("email")) {
                // Save the user
                users.put("email", newUser);
                return true;
            }
        }

        return false;
    }

    private boolean validateEmailPassword(String email, String password) {
        boolean isEmailValid = validator.isEmailValid(email);
        boolean isPasswordValid = validator.isPasswordValid(password);
        return isEmailValid && isPasswordValid;
    }
}
