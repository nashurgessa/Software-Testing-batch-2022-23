package org.example.todo_demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoViewController {

    @FXML
    private ComboBox<Integer> hourComboBox;

    @FXML
    private ComboBox<Integer> minuteComboBox;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize() {
        // Populate hours
        for (int hour = 0; hour < 24; hour++) {
            hourComboBox.getItems().add(hour);
        }

        // Populate minutes
        for (int minute = 0; minute < 60; minute++) {
            minuteComboBox.getItems().add(minute);
        }

        // Select default values if necessary
        hourComboBox.getSelectionModel().select(0); // default to 12
        minuteComboBox.getSelectionModel().select(0); // default to 00
    }

    public void onlogout(ActionEvent actionEvent) throws IOException {
        // Hide or close the current todo app window
        Stage todoStage = (Stage) logoutButton.getScene().getWindow();
        todoStage.close();

        // Load and show the login view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/todo_demo/login_view.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage loginStage = new Stage();
        loginStage.setScene(scene);
        loginStage.setTitle("Login");
        loginStage.show();
    }
}
