package com.example.demo_gui.controller;

import com.example.demo_gui.common.EmailPasswordValidator;
import com.example.demo_gui.common.RegistrationResult;
import com.example.demo_gui.models.User;
import com.example.demo_gui.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistrationController {
    @FXML
    private TextField nameField; // Input field for user's name - 用户名输入字段
    @FXML
    private TextField emailField; // Input field for user's email - 用户邮箱输入字段
    @FXML
    private PasswordField passwordField; // Input field for user's password - 用户密码输入字段
    @FXML
    private PasswordField confirmPasswordField; // Input field for confirming user's password - 确认密码输入字段

    // UserService userService = new UserService();
    UserService userService = UserService.getInstance();

    @FXML
    public void handleRegistrationAction(ActionEvent actionEvent) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        RegistrationResult result  = attemptRegistration(
                name, email, password, confirmPassword);
    }
    public RegistrationResult attemptRegistration(
            String name, String email,
            String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return RegistrationResult.PASSWORD_MISMATCH;
        }
        if ((name != null)  && (email!=null) && (password!=null)) {
            boolean result = userService.registerUser(name, email, password);
            if (result) {
                return RegistrationResult.SUCCESS;
            }
        }
        return RegistrationResult.REGISTRATION_FAILED;
    }

    @FXML
    public void onBackClickButton(ActionEvent actionEvent) throws IOException {

//        try {
            Stage currentStage = (Stage) emailField.getScene().getWindow();
            currentStage.close();

            // Loader
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_gui/login_view.fxml"));
            Scene scene = new Scene(loader.load(), 800, 650);
            // Creating a stage
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Todo LoginPage");
            stage.show();

//        } catch (IOException err) {
//            System.out.println(err.getMessage());
//        }

    }
}
