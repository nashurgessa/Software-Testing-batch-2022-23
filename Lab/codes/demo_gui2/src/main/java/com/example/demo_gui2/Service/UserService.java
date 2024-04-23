package com.example.demo_gui2.Service;

import com.example.demo_gui2.common.EmailPasswordValidator;

public class UserService {
    EmailPasswordValidator validator = new EmailPasswordValidator();
    // Constructor
    public UserService() {
    }
    public boolean login(String email, String password) {
        return "user@example.com".equals(email) && "password".equals(password);
    }
    public boolean registerUser(String name, String email, String password) {
        boolean validationResult = validator(email, password);
        return validationResult;
    }
    public boolean validator(String email, String password) {
        return validator.isEmailValid(email) &&
                validator.isPasswordValid(password);
    }
}
