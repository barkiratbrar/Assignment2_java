package com.example.assignment2_java;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class APIUtility {
    private static final String BASE_URL = "https://www.googleapis.com/books/v1/volumes";

    // Method to search for books using the Google Books API
    public static ApiResponse searchBooks(String query) throws IOException, InterruptedException {
        // Encode the query string to be used in the URL
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String url = BASE_URL + "?q=" + encodedQuery;

        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Send the HTTP request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Initialize Gson for JSON parsing
        Gson gson = new Gson();

        // Parse the JSON response into an ApiResponse object
        return gson.fromJson(response.body(), ApiResponse.class);
    }
}
