package org.example.tesd_1800_javafx.chap16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_28 extends Application {
    public Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 100);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 180);
        primaryStage.setTitle("Exercise16_28");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public StackPane getPane() {
        TextField tf = new TextField("");
        StackPane sPane = new StackPane();
        sPane.getChildren().add(tf);
        tf.setAlignment(Pos.CENTER);
        tf.setFont(font);

        tf.setOnAction(e -> tf.setEditable(false));

        EventHandler<ActionEvent> eventCount = e -> {
            if (!tf.isEditable()) {
                int newNum = Integer.parseInt(tf.getText()) - 1;
                if (newNum == -1) {
                    new MediaPlayer(new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3")).play();
                } else
                    tf.setText("" + newNum);
            }
        };

        Timeline tl = new Timeline(new KeyFrame(Duration.millis(1000), eventCount));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();

        return sPane;
    }
}
