module com.example.demo_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.demo_gui to javafx.fxml;
    exports com.example.demo_gui;
    exports com.example.demo_gui.utils;
    opens com.example.demo_gui.utils to javafx.fxml;
}