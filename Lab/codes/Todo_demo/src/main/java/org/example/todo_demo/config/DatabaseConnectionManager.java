package org.example.todo_demo.config;

// using **Class.forName()** with **DriverManager**
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "mocha123";

    // Load the  database driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException err) {
            System.out.println("Error loading driver: " + err.getMessage());
        }
    }

    // Provide a method to get a database  connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
                // Optionally, you can check if the connection is closed
                if (connection.isClosed()) {
                    System.out.println("However, the connection is currently closed.");
                } else {
                    System.out.println("Connection is active.");
                }
                // Close the connection
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}
