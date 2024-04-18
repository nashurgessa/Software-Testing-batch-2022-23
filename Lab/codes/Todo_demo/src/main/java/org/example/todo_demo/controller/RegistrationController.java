package org.example.todo_demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.todo_demo.common.RegistrationResult;
import org.example.todo_demo.services.UserService;
import org.example.todo_demo.utils.AlertMessages;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button backButton;

    // private UserService userService = new UserService();
    private UserService userService = UserService.getInstance();

    public void onBackClickButton(ActionEvent actionEvent) throws IOException {
        backToLoginPage();
    }

    public void backToLoginPage() throws IOException {
        // Hide or close the current todo app window
        Stage todoStage = (Stage) backButton.getScene().getWindow();
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
    @FXML
    public void handleRegistrationAction(ActionEvent actionEvent) throws IOException {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        System.out.println("name : "+ name+ " email: "+email+ " password: "
                +password+ " confirm password: " + confirmPassword);

//        if (!password.equals(confirmPassword)) {
//            // Password don't match
//            // Show error message
//            return;
//        }
//
//        if (isValidEmail(email) && isValidPassword(password) && !name.isEmpty()) {
//            // Registration successful
//            boolean isRegistered = userService.registerUser(name, email, password);
//            // Navigate to login page or show success message
//            backToLoginPage();
//
//        } else {
//            // Registration failed
//            // Show error message
//            AlertMessages.showErrorToUser("Registration", "Registration Failed");
//        }

        RegistrationResult result = attemptRegistration(name, email, password, confirmPassword);

        switch (result) {
            case SUCCESS:
                backToLoginPage();
                break;
            case PASSWORD_MISMATCH:
            case REGISTRATION_FAILED:
                AlertMessages.showErrorToUser("Registration", "Registration Failed");
                break;
        }
    }

    // This we can use the White box testing
    // New method to encapsulate the registration logic
    protected RegistrationResult attemptRegistration(String name, String email, String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            return RegistrationResult.PASSWORD_MISMATCH;
        }

        if (isValidEmail(email) && isValidPassword(password) && !name.isEmpty() &&
                userService.registerUser(name, email, password)) {
            return RegistrationResult.SUCCESS;
        } else {
            return RegistrationResult.REGISTRATION_FAILED;
        }
    }



    // Validate email format
    protected boolean isValidEmail(String email) {
        /*
        ^: Start of the string.
           [A-Za-z0-9+_.-]+: Matches one or more characters that are alphanumeric (A-Za-z0-9), plus (+), underscore (_), dot (.), or hyphen (-). This part is intended to match the user name part of the email address before the @ symbol.
           @: Matches the @ symbol itself, which is a required character in email addresses.
           [A-Za-z0-9.-]+: Matches one or more characters that are alphanumeric (A-Za-z0-9), dot (.), or hyphen (-). This part is intended to match the domain part of the email address after the @ symbol. It can match domains like example.com or subdomains like sub.example.com.
           $: End of the string.
         */
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern emailPart = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPart.matcher(email);

        return matcher.find();
    }

    // Validate password complexity
    protected boolean isValidPassword(String password) {
        /*
        ^: Start of string.
        (?=.*[0-9]): At least one digit.
        (?=.*[a-z]): Ensures that there is at least one lowercase letter (not explicitly required by your rules but generally considered a good practice for password security).
        (?=.*[A-Z]): At least one uppercase letter.
        (?=.*[@#$%^&+=]): At least one special character from the set specified.
        (?=\\S+$): No whitespace allowed in the entire string.
        .{8,24}$: Between 6 to 24 characters.
         */
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,24}$";
        Pattern passwordPat = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPat.matcher(password);
        return matcher.matches();
    }
}


