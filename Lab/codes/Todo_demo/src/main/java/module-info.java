module org.example.todo_demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens org.example.todo_demo to javafx.fxml;
    exports org.example.todo_demo;
    exports org.example.todo_demo.controller;
    opens org.example.todo_demo.controller to javafx.fxml;
}