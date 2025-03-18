module org.example.tesd_1800_javafx.chap16 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens org.example.tesd_1800_javafx.chap16 to javafx.fxml;
    exports org.example.tesd_1800_javafx.chap16;
}