package com.example.demo_gui2.Service;

public class UserService {
    // Constructor
    public UserService() {
    }
    public boolean login(String email, String password) {
        return "user@example.com".equals(email) && "password".equals(password);
    }

    public boolean registerUser(String name, String email, String password) {
        return true;
    }
}
