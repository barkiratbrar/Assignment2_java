package com.example.assignment2_java;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApiResponse {
    // Define a field to hold a list of Book objects
    @SerializedName("items")
    private List<Book> items;

    // Getter method to retrieve the list of Book items
    public List<Book> getItems() {
        return items;
    }

    // Setter method to set the list of Book items
    public void setItems(List<Book> items) {
        this.items = items;
    }
}
