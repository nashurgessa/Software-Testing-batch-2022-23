package org.example.todo_demo.repository;

import javax.print.DocFlavor;

public interface UserRepository {
    void addUser(String name, String email, String password);
}
