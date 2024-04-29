module org.example.todo_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires okhttp3;
    requires com.fasterxml.jackson.databind;
    requires mysql.connector.j;
    requires java.sql;

    opens org.example.todo_demo to javafx.fxml;
    exports org.example.todo_demo;
    exports org.example.todo_demo.controller;
    opens org.example.todo_demo.controller to javafx.fxml;
    exports org.example.todo_demo.common;
    opens org.example.todo_demo.common to javafx.fxml;
}