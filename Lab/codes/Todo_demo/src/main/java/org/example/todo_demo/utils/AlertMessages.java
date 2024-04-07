package org.example.todo_demo.utils;

import javafx.scene.control.Alert;

public class AlertMessages {
    public static void showErrorToUser(String title, String message) {
        // Show a more user-friendly error using JavaFX components, like Alert
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
