package org.example.gui_based_quadratic_roots;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create an FXMLLoader instance to load the FXML file.
        // getClass().getResource("quadratic-gui.fxml") locates the FXML file
        // in the same directory as the HelloApplication class.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("quadratic-gui.fxml"));

        // loader.setRoot(mew AnchorPage)  // if the root is not mentioned inside fxml - start with fx.root

        // No need to manually set an AnchorPane as root here because the root element is defined in the FXML file.
        // The load() method processes the FXML file and automatically sets up the root element.
        // This root element is what we've defined inside the FXML with <fx:root>.
        Parent root = loader.load();

        // Create a new Scene with the root element loaded from the FXML file.
        // The dimensions are set to 500x350, but these can be adjusted as needed.
        Scene scene = new Scene(root, 600, 450);

        // Set the title of the application window.
        stage.setTitle("Quadratic Root GUI!");

        // Set the scene for the stage. The scene contains all the visual elements.
        stage.setScene(scene);

        // Display the application window.
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application. This method creates an instance of
        // HelloApplication and calls the start method on the JavaFX Application Thread.
        launch();
    }
}