// Barkirat Singh Brar
// 200554052
// Java Assignment 2

package com.example.assignment2_java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the initial view
        Parent root = FXMLLoader.load(getClass().getResource("search-view.fxml"));

        // Set the title of the primary stage
        primaryStage.setTitle("Book Search Application");

        // Set the scene with the loaded FXML file
        primaryStage.setScene(new Scene(root));

        // Display the primary stage
        primaryStage.show();
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
