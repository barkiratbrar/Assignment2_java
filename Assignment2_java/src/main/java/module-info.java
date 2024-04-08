module com.example.assignment2_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.assignment2_java to javafx.fxml, com.google.gson;

    exports com.example.assignment2_java;
}