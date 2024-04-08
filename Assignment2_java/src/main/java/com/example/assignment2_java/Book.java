package com.example.assignment2_java;

import com.google.gson.annotations.SerializedName;

public class Book {
    // Serialized name for the book's ID field
    @SerializedName("id")
    private String id;

    // VolumeInfo object containing detailed information about the book
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    // Getters and Setters for the Book class
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}
