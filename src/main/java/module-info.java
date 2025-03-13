module org.example.tesd_1800_javafx.chap14 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.tesd_1800_javafx.chap14 to javafx.fxml;
    exports org.example.tesd_1800_javafx.chap14;
}