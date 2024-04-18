package com.example.demo_gui.controller;

import com.example.demo_gui.utils.AlertMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
        if (!authenticateUser(txtUsername.getText(), txtPassword.getText())) {
            // 如果不正确，显示错误信息 (If incorrect, display an error message)
            return;
        }

        // 如果正确，进入待办事项应用 (If correct, proceed to the Todo app)
        try {
            navigateToTodoApp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 将场景更改为待办事项应用的方法 (Method to change the scene to the Todo app)
    private void navigateToTodoApp() throws IOException {
        try {
            Stage loginStage = getCurrentStage();
            loginStage.hide();

            Parent root = loadTodoView();
            Scene todoScene = new Scene(root, 800, 600);
            Stage todoStage = createStage(todoScene, "Todo App");

            todoStage.show();
        } catch (IOException e) {
            e.getMessage(); // Handle the exception as appropriate for your application
        }
    }

    private Stage getCurrentStage() {
        return (Stage) txtUsername.getScene().getWindow();
    }

    private Parent loadTodoView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_gui/todo_view.fxml"));
        return loader.load();
    }

    private Stage createStage(Scene scene, String title) {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        return stage;
    }


    // 用于检查登录凭据的辅助方法 (Helper method to check login credentials)
    private boolean authenticateUser(String username, String password) {
        // return userService.login(username, password);
        return true;
    }

    public void goToRegistrationPage(ActionEvent actionEvent) {
    }
}
