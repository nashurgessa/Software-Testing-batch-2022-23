package com.example.demo_gui.service;

import com.example.demo_gui.common.EmailPasswordValidator;

public class UserService {

    // Constructor

    public UserService() {
    }

    EmailPasswordValidator validator = new EmailPasswordValidator();

    public boolean login(String email, String password) {
        return "user".equals(email) && "password".equals(password);
    }

    public boolean registerUser(String name, String email, String password) {
        boolean validatorResult = validateEmailPassword(email, password);
        // Todo
        return validatorResult;
    }

    private boolean validateEmailPassword(String email, String password) {
        boolean isEmailValid = validator.isEmailValid(email);
        boolean isPasswordValid = validator.isPasswordValid(password);
        return isEmailValid && isPasswordValid;
    }
}
