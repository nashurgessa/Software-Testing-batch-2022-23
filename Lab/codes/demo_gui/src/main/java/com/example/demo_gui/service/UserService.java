package com.example.demo_gui.service;

public class UserService {

    // Constructor

    public UserService() {
    }

    public boolean login(String email, String password) {
        return "user".equals(email) && "password".equals(password);
    }

//    public boolean registerUser() {
//
//
//    }
}
