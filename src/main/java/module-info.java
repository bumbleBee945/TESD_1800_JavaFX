module org.example.tesd_1800_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tesd_1800_javafx to javafx.fxml;
    exports org.example.tesd_1800_javafx;
}