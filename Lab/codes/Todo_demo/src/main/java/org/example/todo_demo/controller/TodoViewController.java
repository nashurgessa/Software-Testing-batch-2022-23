package org.example.todo_demo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.todo_demo.common.HttpBackendConnector;
import org.example.todo_demo.model.Todo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TodoViewController {

    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<Integer> hourComboBox;

    @FXML
    private ComboBox<Integer> minuteComboBox;

    @FXML
    private TextField txtTitleField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Button addTaskButton;

    @FXML
    private Button logoutButton;

    @FXML
    private ListView<Todo> myListView;


    HttpBackendConnector http = HttpBackendConnector.getInstance();


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

        // Setup click listener
        myListView.setOnMouseClicked(event -> handleTodoTaskClicked(event));
    }

    private void handleTodoTaskClicked(MouseEvent event) {
        // Get the selected item
        Todo selectedItem = myListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Perform your actions here with the selected item
            System.out.println("Clicked on " + selectedItem);
        }
    }

    @FXML
    public void onLogout(ActionEvent actionEvent) throws IOException {
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

    @FXML
    public void onAddNewTask(ActionEvent actionEvent) {
        String title = txtTitleField.getText();
        String description = descriptionTextArea.getText();
        LocalDate date = datePicker.getValue();
        LocalTime time = LocalTime.of(Integer.parseInt(String.valueOf(hourComboBox.getValue())),
                Integer.parseInt(String.valueOf(minuteComboBox.getValue())));

        // new Todo, object
        Todo newTodo = new Todo(title, description, date, time);
        myListView.getItems().add(newTodo);

        // Todo, add to local Database

        // Add to the server
        sendToServer(newTodo);

        // Clear the form fields after adding
        txtTitleField.clear();
        descriptionTextArea.clear();
        datePicker.setValue(null);
        hourComboBox.getSelectionModel().clearSelection();
        minuteComboBox.getSelectionModel().clearSelection();
    }

    private void sendToServer(Todo newTodo) {

        String jsonPayload = newTodo.getJson();

        Response jsonResponse = http.sendPost(jsonPayload, "add_todo");

        assert jsonResponse.body() != null;
        System.out.println(jsonResponse.body().toString());
    }


}
