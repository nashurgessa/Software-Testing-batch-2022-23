package com.example.demo_gui2.Service;

import com.example.demo_gui2.common.EmailPasswordValidator;
import com.example.demo_gui2.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    EmailPasswordValidator validator = new EmailPasswordValidator();
    // Constructor
    private UserService() {
    }

    private static UserService instance;

    public static synchronized UserService getInstance(){
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    // Faking using HashMap;
    private final Map<String, User> users = new HashMap<>();

    public boolean registerUser(String name, String email, String password) {
        // Checks if the email and password are valid
        boolean validationResult = validator(email, password);
        // if email and password are valid, then we create a new user model
        if(validationResult){
            // Created a user
            User newUser = new User(name, email, password);
            System.out.println("The new user info: "+ newUser.toString());
            // first check if the_word "register_user" exist inside the dict
            if (!users.containsKey("registered_user")) {
                // it is time to save the user
                users.put("registered_user", newUser);
                return true;
            }
            else {
                return false;
            }
        }
        return  false;
    }

    public boolean login(String email, String password) {
        // return "user@example.com".equals(email) && "password".equals(password);
        if (users.containsKey("registered_user")) {
            // This will get the registered User
            User user = users.get("registered_user");
            return user.getEmail().equals(email)
                    && user.getPassword().equals(password);
        }
        return false;
    }

    public boolean validator(String email, String password) {
        return validator.isEmailValid(email) &&
                validator.isPasswordValid(password);
    }
}
