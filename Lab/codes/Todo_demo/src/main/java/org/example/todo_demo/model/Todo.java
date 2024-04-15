package org.example.todo_demo.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Todo {
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    ObjectMapper mapper = new ObjectMapper();

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


    public String getJson() {
        Map<String, String> payload = new HashMap<>();
        payload.put("title", this.title);
        payload.put("date", this.date.toString());
        payload.put("time", this.time.toString());
        payload.put("description", this.description);

        try {
            return mapper.writeValueAsString(payload);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time.toString();
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
