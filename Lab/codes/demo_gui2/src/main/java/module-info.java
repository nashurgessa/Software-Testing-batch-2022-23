module com.example.demo_gui2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.example.demo_gui2 to javafx.fxml;
    exports com.example.demo_gui2;

    exports com.example.demo_gui2.controller to javafx.fxml;
    opens com.example.demo_gui2.controller to javafx.fxml;
}