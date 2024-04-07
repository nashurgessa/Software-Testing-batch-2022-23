package org.example.todo_demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.todo_demo.config.Configuration;
import org.example.todo_demo.services.UserService;
import org.example.todo_demo.utils.AlertMessages;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    private UserService userService = UserService.getInstance(); // GET THE SINGLETON

    @FXML
    protected void onSignIn(ActionEvent actionEvent) {
        if (!authenticateUser(txtUsername.getText(), txtPassword.getText())) {
            AlertMessages.showErrorToUser("Login Failed", "Incorrect username or password.");
            return;
        }
        navigateToTodoApp();
    }

    private boolean authenticateUser(String username, String password) {
        // Use userService to validate credentials
        return userService.login(username, password);
    }

    private void navigateToTodoApp() {
        try {
            Stage loginStage = getCurrentStage();
            loginStage.hide();

            Parent root = loadTodoView();
            Scene todoScene = new Scene(root, 800, 600);

            Stage todoStage = createStage(todoScene, "Todo App");

//            configureWindowResize(todoStage);
//            addAppToSystemTray(todoStage);

            todoStage.show();
        } catch (IOException e) {
            e.getMessage(); // Handle the exception as appropriate for your application
        }
    }

    // Rest of your methods here...
    // Including showErrorToUser, getCurrentStage, loadTodoView, createStage, etc.
//    private void showErrorToUser() {
//        // Implementation of showing error to the user
//        System.out.println("Authentication failed");
//    }



    private Stage getCurrentStage() {
        return (Stage) txtUsername.getScene().getWindow();
    }

    private Parent loadTodoView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/todo_demo/todo_view.fxml"));
        return loader.load();
    }

    private Stage createStage(Scene scene, String title) {
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        return stage;
    }

//    private void configureWindowResize(Stage stage) {
//        // Assuming Configuration.windowResizeCancelController(Stage stage) exists and configures the stage
//        Configuration.windowResizeCancelController(stage);
//    }
//
//    private void addAppToSystemTray(Stage stage) {
//        // Assuming Configuration.addAppToSystemTray(Stage stage) exists and adds the app to the system tray
//        Configuration.addAppToSystemTray(stage);
//    }


    @FXML
    public void goToRegistrationPage(ActionEvent actionEvent) {
        try {
            Stage currentStage = getCurrentStage();
            currentStage.close();

            Parent root = loadRegistrationView();
            Scene scene = new Scene(root, 500, 600);
            Stage registrationStage = createStage(scene, "Registration");
            registrationStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as appropriate for your application
        }
    }

    private Parent loadRegistrationView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/todo_demo/registration_view.fxml"));
        return loader.load();
    }
}
