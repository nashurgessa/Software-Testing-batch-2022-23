package com.example.demo_gui2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private TextField nameField; // Input field for user's name - 用户名输入字段
    @FXML
    private TextField emailField; // Input field for user's email - 用户邮箱输入字段
    @FXML
    private PasswordField passwordField; // Input field for user's password - 用户密码输入字段
    @FXML
    private PasswordField confirmPasswordField; // Input field for confirming user's password - 确认密码输入字段

    @FXML
    public void handleRegistrationAction(ActionEvent actionEvent) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        System.out.println("name: "+ name+ " email"+ email);
    }

    @FXML
    public void onBackClickButton(ActionEvent actionEvent) throws IOException {
        try {
            // close the current window
            Stage currentStage = (Stage) nameField.getScene().getWindow();
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
