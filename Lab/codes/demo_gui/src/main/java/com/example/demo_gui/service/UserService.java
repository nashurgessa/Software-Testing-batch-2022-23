package com.example.demo_gui.service;

import com.example.demo_gui.common.EmailPasswordValidator;

public class UserService {

    EmailPasswordValidator emailPasswordValidator = new EmailPasswordValidator();

    // contructor
    public UserService() {

    }

    public boolean login(String email, String password) {
        // TODO validate
        boolean isValid = isValidEmailPassword(email, password);
        if (isValid) {
            return "user@gmail.com".equals(email) && "Password123@".equals(password);
        }
        else {
            return false;
        }

    }

    private boolean isValidEmailPassword(String email, String password){
        boolean isValidEmail = emailPasswordValidator.isEmailValid(email);
        boolean isValidPassword = emailPasswordValidator.isPasswordValid(password);
        System.out.println(isValidEmail + " " +isValidPassword);
        return true;
        // return emailPasswordValidator.isEmailValid(email) && emailPasswordValidator.isPasswordValid(password);
    }

}
