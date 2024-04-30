package com.example.demo_gui2.Service;

import com.example.demo_gui2.common.EmailPasswordValidator;
import com.example.demo_gui2.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    EmailPasswordValidator validator = new EmailPasswordValidator();
    // Constructor
    public UserService() {
    }

    // in-memory
    private final Map<String, User> users = new HashMap<>();

    public boolean login(String email, String password) {
        return "user@example.com".equals(email) && "password".equals(password);
    }
    public boolean registerUser(String name, String email, String password) {
        // Checks if the email and password are valid
        boolean validationResult = validator(email, password);
        // if email and password are valid, then we create a new user model
        if(validationResult){

            User newUser = new User(name, email, password);
            System.out.println("The new user info: "+ newUser.toString());
            // it is time to save the user
            users.put("register_user", newUser);

            return true;
        }
        return false;
    }
    public boolean validator(String email, String password) {
        return validator.isEmailValid(email) &&
                validator.isPasswordValid(password);
    }
}
