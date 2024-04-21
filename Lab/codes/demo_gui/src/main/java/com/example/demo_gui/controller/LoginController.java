package com.example.demo_gui.controller;

import com.example.demo_gui.TodoApplication;
import com.example.demo_gui.service.UserService;
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

    private UserService userService = new UserService();

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
            System.out.println("The username or password is mismatch");
            return;
        }

        // 如果正确，进入待办事项应用 (If correct, proceed to the Todo app)
        navigateToTodoApp();
    }

    protected void navigateToTodoApp() {
        try {

            Stage loginStage = getCurrentStage();
            loginStage.hide();

            // now time to load and create a scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_gui/todo_view.fxml"));
            // Sceen
            Scene scene = new Scene(loader.load(), 800, 600);
            // create a stage
            Stage stage = new Stage();
            // add scene to the stage
            stage.setScene(scene);
            stage.setTitle("NeuTodo");

            // show stage
            stage.show();

        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
//
//    // 将场景更改为待办事项应用的方法 (Method to change the scene to the Todo app)
//    private void navigateToTodoApp() throws IOException {
//        try {
//            Stage loginStage = getCurrentStage();
//            loginStage.hide();
//
//            Parent root = loadTodoView();
//            Scene todoScene = new Scene(root, 800, 600);
//            Stage todoStage = createStage(todoScene, "Todo App");
//
//            todoStage.show();
//        } catch (IOException e) {
//            e.getMessage(); // Handle the exception as appropriate for your application
//        }
//    }
//
//    private Stage getCurrentStage() {
//        return (Stage) txtUsername.getScene().getWindow();
//    }
//
//    private Parent loadTodoView() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo_gui/todo_view.fxml"));
//        return loader.load();
//    }
//
//    private Stage createStage(Scene scene, String title) {
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.setTitle(title);
//        return stage;
//    }


    // 用于检查登录凭据的辅助方法 (Helper method to check login credentials)
    private boolean authenticateUser(String username, String password) {
        return userService.login(username, password);
        // return true;
    }

    @FXML
    public void goToRegistrationPage(ActionEvent actionEvent) throws IOException {
        try {
            // get the current window
            Stage currentStage = getCurrentStage();
            currentStage.close();

            // LoadFXML
            FXMLLoader loader = new FXMLLoader(RegistrationController.class.getResource("/com/example/demo_gui/registartion_view.fxml"));

            // Create Scene
            Scene registrationScene = new Scene(loader.load(), 800, 600);

            // Stage
            Stage stage = new Stage();
            stage.setScene(registrationScene);
            stage.setTitle("Registration Page");
            stage.show();
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }

    private Stage getCurrentStage() {
        return (Stage) txtUsername.getScene().getWindow();
    }
}
