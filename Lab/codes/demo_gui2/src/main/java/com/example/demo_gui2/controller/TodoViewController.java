package com.example.demo_gui2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoViewController {
    @FXML
    private TextField txtTitleField;
    @FXML
    private ComboBox hourComboBox;
    @FXML
    private ComboBox minuteComboBox;
    @FXML
    private DatePicker datePicker;

    @FXML
    public void initialize() {
        // Populate the hour
        for (int hour=0; hour<24; hour++){
            hourComboBox.getItems().add(hour);
        }

        for (int minute=0; minute<60; minute++) {
            minuteComboBox.getItems().add(minute);
        }

        // Set a default
        hourComboBox.getSelectionModel().select(0);

        minuteComboBox.getSelectionModel().select(0);
    }

    @FXML
    public void onAddNewTask(ActionEvent actionEvent) {
    }

    @FXML
    public void onLogout(ActionEvent actionEvent) throws IOException {

        // Go back to login

        try {
            // close the current window
            Stage currentStage = (Stage) txtTitleField.getScene().getWindow();
            currentStage.close();


            FXMLLoader loader = new FXMLLoader(RegistrationController.class.getResource("/com/example/demo_gui2/login_view.fxml"));

            Scene scene = new Scene(loader.load(), 800, 650);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Login Page");

            stage.show();

        } catch (IOException err){
            System.out.println(err.getMessage());
        }

    }
}
