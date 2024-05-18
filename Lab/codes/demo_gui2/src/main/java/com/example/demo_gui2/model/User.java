package com.example.demo_gui2.model;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private String email;
    private String password;

    ObjectMapper mapper = new ObjectMapper();

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

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
        return "name: "+ name + " email : " + email + " password: "+ password;
    }


    public String getJson() {
        Map<String, String> payload = new HashMap<>();
        payload.put("name", this.name);
        payload.put("email", this.email);
        payload.put("password", this.password);

        try {
            return mapper.writeValueAsString(payload);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

}