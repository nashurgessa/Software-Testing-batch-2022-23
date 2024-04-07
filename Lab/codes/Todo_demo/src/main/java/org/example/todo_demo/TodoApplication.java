package org.example.todo_demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.todo_demo.config.Configuration;

import java.io.IOException;

public class TodoApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Platform.setImplicitExit(false); // Keep application running in background


//        stage.setResizable(false);
//
//        stage.setOnCloseRequest(event -> {
//            // Prevent the window from closing
//            event.consume();
//
//            // Optionally, minimize the window instead
//            stage.setIconified(true);
//        });
        // Configuration.widowResizeCancelController(stage);
        // Call method to add application to system tray
        // Configuration.addAppToSystemTray(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(TodoApplication.class.getResource("login_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 550);
        stage.setTitle("Todo App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}