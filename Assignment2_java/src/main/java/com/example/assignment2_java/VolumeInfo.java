package com.example.assignment2_java;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

public class VolumeInfo {
    @SerializedName("title")
    private String title;

    @SerializedName("authors")
    private List<String> authors;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("description")
    private String description;

    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    // Getters and Setters for each field

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        // Return an empty list instead of null to avoid NullPointerException
        return authors != null ? authors : Collections.emptyList();
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    // Custom method to get authors as a comma-separated string
    public String getAuthorsAsString() {
        // Using getAuthors() method to ensure we get the safe, non-null list
        return !getAuthors().isEmpty() ? String.join(", ", getAuthors()) : "No authors listed";
    }
}
