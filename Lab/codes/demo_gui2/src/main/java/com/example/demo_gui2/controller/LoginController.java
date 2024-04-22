package com.example.demo_gui2.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername; // 用户名输入字段 (Input field for the username)
    @FXML
    private TextField txtPassword; // 密码输入字段 (Input field for the password)

    // 点击登录按钮时处理登录的方法 (Method to handle login when the Sign In button is clicked)
    @FXML
    protected void onSignIn(ActionEvent actionEvent) {
        // 验证用户名和密码是否正确 (Check if the username and password are correct)
        String email = txtUsername.getText();
        String password = txtPassword.getText();

        if (!authenticateUser(email, password)) {
            // 如果不正确，显示错误信息 (If incorrect, display an error message)
            System.out.println("The username or password is mismatch");
            return;
        }
        // 如果正确，进入待办事项应用 (If correct, proceed to the Todo app)
        // navigateToTodoApp();
    }

    private boolean authenticateUser(String email, String password) {
        // return userService.login(email, password);
        return true;
    }

    @FXML
    public void goToRegistrationPage(ActionEvent actionEvent) throws IOException {
    }
    // 用于检查登录凭据的辅助方法 (Helper method to check login credentials)
}
