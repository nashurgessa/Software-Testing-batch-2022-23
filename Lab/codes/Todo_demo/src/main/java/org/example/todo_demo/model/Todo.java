package org.example.todo_demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Todo {
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    // Constructor
    public Todo(String title, String description, LocalDate date, LocalTime time) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    // Getters and setters
    // toString() method to display Todo in the ListView
    @Override
    public String toString() {
        return title + " - " + date.toString() + " " + time.toString();
    }
}
