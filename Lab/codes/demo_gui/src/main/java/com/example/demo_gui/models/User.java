package com.example.demo_gui.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class User {
    private String name;
    private String email;
    private String password;

    ObjectMapper mapper = new ObjectMapper();

    // Constructor
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // setter and getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "name: "+ name + " email: " + email+ " password: "+ password ;
    }


}
