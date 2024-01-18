module com.example.zadaniezjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadaniezjavafx to javafx.fxml;
    exports com.example.zadaniezjavafx;
}