package com.example.assignment2_java;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoViewController {

    // FXML elements from the corresponding FXML file
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorsLabel;
    @FXML
    private Label publisherLabel;
    @FXML
    private ImageView coverImageView;
    @FXML
    private TextArea descriptionArea;

    // Method to set the book information on the view
    public void setBook(Book book) {
        // Check if the book and its volume info are not null
        if (book != null && book.getVolumeInfo() != null) {
            VolumeInfo volumeInfo = book.getVolumeInfo();

            // Set the title, authors, description, and publisher labels
            titleLabel.setText(volumeInfo.getTitle());
            authorsLabel.setText(volumeInfo.getAuthorsAsString());
            descriptionArea.setText(volumeInfo.getDescription());
            publisherLabel.setText(volumeInfo.getPublisher());

            // Check if image links are available and set the cover image
            if (volumeInfo.getImageLinks() != null && volumeInfo.getImageLinks().getThumbnail() != null) {
                Image image = new Image(volumeInfo.getImageLinks().getThumbnail(), true);
                coverImageView.setImage(image);
            }
        }
    }

    // Method to handle the back button action
    @FXML
    private void handleBackAction() {
        try {
            // Change scenes back to the search view
            SceneChanger.changeScenes((Stage) titleLabel.getScene().getWindow(), "search-view.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
