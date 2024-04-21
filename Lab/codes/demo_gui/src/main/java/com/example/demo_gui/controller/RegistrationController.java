package com.example.demo_gui.controller;

import com.example.demo_gui.common.RegistrationResult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button backButton; // Button to navigate back - 返回按钮


    // Event handler for back button to return to login page - 返回按钮的事件处理，返回登录页面
    public void onBackClickButton(ActionEvent actionEvent)  throws IOException {

        try {// Implementation
            // get the stage
            Stage thisStage = (Stage) nameField.getScene().getWindow();
            thisStage.close();

            // load the loginPage
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_gui/login_view.fxml"));
            Scene scene = new Scene(loader.load(), 800, 650);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Todo App");

            stage.show();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }


    }

    // Handles registration form submission - 处理注册表单提交
    @FXML
    protected void handleRegistrationAction(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        // RegistrationResult result = attemptRegistration(name, email, password, confirmPassword);

    }

    // Encapsulates the registration logic - 封装注册逻辑
//    protected RegistrationResult attemptRegistration(String name, String email, String password, String confirmPassword) {
//
//    }

    // Validates the email format - 验证电子邮件格式
    private boolean isValidEmail(String email) {
        /*
        ^: Start of the string.
           [A-Za-z0-9+_.-]+: Matches one or more characters that are alphanumeric (A-Za-z0-9), plus (+), underscore (_), dot (.), or hyphen (-). This part is intended to match the user name part of the email address before the @ symbol.
           @: Matches the @ symbol itself, which is a required character in email addresses.
           [A-Za-z0-9.-]+: Matches one or more characters that are alphanumeric (A-Za-z0-9), dot (.), or hyphen (-). This part is intended to match the domain part of the email address after the @ symbol. It can match domains like example.com or subdomains like sub.example.com.
           $: End of the string.
         */

        return true;
    }

    // Validates the password complexity - 验证密码复杂度
    private boolean isValidPassword(String password) {
        /*
        ^: Start of string.
        (?=.*[0-9]): At least one digit.
        (?=.*[a-z]): Ensures that there is at least one lowercase letter (not explicitly required by your rules but generally considered a good practice for password security).
        (?=.*[A-Z]): At least one uppercase letter.
        (?=.*[@#$%^&+=]): At least one special character from the set specified.
        (?=\\S+$): No whitespace allowed in the entire string.
        .{8,24}$: Between 8 to 24 characters.
         */
        return true;
    }
}
