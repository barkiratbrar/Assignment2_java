package com.example.assignment2_java;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private TextField searchTextField;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorsColumn;
    @FXML
    private TableColumn<Book, String> publisherColumn;

    // Initialize method called when the FXML is loaded
    public void initialize() {
        // Set cell value factories for table columns
        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVolumeInfo().getTitle()));
        authorsColumn.setCellValueFactory(cellData -> new SimpleStringProperty(String.join(", ", cellData.getValue().getVolumeInfo().getAuthors())));
        publisherColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVolumeInfo().getPublisher()));

        // Set initial table items and perform a default search
        tableView.setItems(FXCollections.observableArrayList());
        searchBooks("default search term");

        // Set double click event handler for table rows
        tableView.setRowFactory(tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    Book clickedBook = row.getItem();
                    showBookDetails(clickedBook);
                }
            });
            return row;
        });
    }

    // Method to show book details in a new scene
    private void showBookDetails(Book book) {
        try {
            SceneChanger.changeScenes((Stage) tableView.getScene().getWindow(), "details-view.fxml", book);
        } catch (IOException e) {
            e.printStackTrace();  // Or handle the exception as needed
        }
    }

    // Method triggered when the search button is clicked
    @FXML
    private void onSearchButtonClick() {
        String query = searchTextField.getText();
        if (!query.isEmpty()) {
            searchBooks(query);
        }
    }

    // Method to search books using the APIUtility class
    private void searchBooks(String query) {
        try {
            ApiResponse response = APIUtility.searchBooks(query);
            if (response != null && response.getItems() != null) {
                tableView.setItems(FXCollections.observableArrayList(response.getItems()));
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle the error appropriately
        }
    }
}
