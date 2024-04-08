package com.example.assignment2_java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneChanger {

    // Method to change scenes without needing a Book object
    public static void changeScenes(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneChanger.class.getResource("search-view.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
    public static void changeScenes(Stage stage, String s, Book selectedBook) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneChanger.class.getResource("details-view.fxml"));
        Parent parent = loader.load();
        InfoViewController controller = loader.getController();
        controller.setBook(selectedBook);

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}

