package com.example.assignment2_java;

import com.google.gson.annotations.SerializedName;

public class ImageLinks {
    // Serialized name for the thumbnail URL field
    @SerializedName("thumbnail")
    private String thumbnail;

    // Getter and Setter for the thumbnail URL
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
