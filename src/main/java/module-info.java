module org.example.tesd_1800_javafx.chap15 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tesd_1800_javafx.chap15 to javafx.fxml;
    exports org.example.tesd_1800_javafx.chap15;
}