package org.example.todo_demo.config;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.awt.*;

public class Configuration {

    public static void windowResizeCancelController(Stage stage) {
        stage.setResizable(false);

        stage.setOnCloseRequest(event -> {
            // Prevent the window from closing
            // event.consume();

            // Optionally, minimize the window instead
            stage.setIconified(true);

        });

    }

    public static void addAppToSystemTray(Stage primaryStage) {
        // Ensure AWT is initialized
        java.awt.Toolkit.getDefaultToolkit();

        // Check if the system tray is supported
        if (!SystemTray.isSupported()) {
            System.out.println("System tray not supported");
            return;
        }

        // Run this part on the AWT dispatch thread to prevent potential deadlocks and race conditions
        Platform.runLater(() -> {
            Image image = java.awt.Toolkit.getDefaultToolkit().getImage("path/to/your/icon.png"); // Your application icon
            TrayIcon trayIcon = new TrayIcon(image);
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Your Application Name");

            // Create a popup menu for the tray icon
            PopupMenu popup = new PopupMenu();
            MenuItem showItem = new MenuItem("Show");
            showItem.addActionListener(event -> Platform.runLater(primaryStage::show));
            MenuItem exitItem = new MenuItem("Exit");
            exitItem.addActionListener(event -> {
                SystemTray.getSystemTray().remove(trayIcon);
                Platform.exit();
            });

            popup.add(showItem);
            popup.addSeparator();
            popup.add(exitItem);
            trayIcon.setPopupMenu(popup);

            try {
                SystemTray.getSystemTray().add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Unable to add icon to system tray");
            }
        });
    }

}
