module org.example.gui_based_quadratic_roots {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens org.example.gui_based_quadratic_roots to javafx.fxml;
    exports org.example.gui_based_quadratic_roots;
}