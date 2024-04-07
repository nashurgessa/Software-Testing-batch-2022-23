package org.example.todo_demo.model;

public class User {

    private String name;
    private String email;
    private String password;

    // Constructor
    public User(String name, String email, String password) {
        this.name =  name;
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
        return "The name: "+ this.name + " email :"+ this.email + " and password: " + this.password;
    }
}
