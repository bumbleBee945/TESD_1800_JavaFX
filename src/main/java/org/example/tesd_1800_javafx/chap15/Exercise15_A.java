package org.example.tesd_1800_javafx.chap15;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_A extends Application {
    boolean playing = true;
    public static void main(String[] args) {
        launch(args);
    }
    private void togglePlaying(PathTransition pt, FadeTransition ft) {
        if (playing) {
            pt.pause();
            ft.pause();
            playing = false;
        } else {
            pt.play();
            ft.play();
            playing = true;
        }
    }
    public void start(Stage primaryStage) {
        // Create main panel
        StackPane stackPane = new StackPane();
        // Create pentagon/circle
        Polygon pentagon = new Polygon(15.0, -15.0, 55.0, 25.0, 35.0, 65.0, -5.0, 65.0, -25.0, 25.0);
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        pentagon.setFill(Color.WHITE);
        pentagon.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.LIGHTSLATEGRAY);
        // Create path transition
        PathTransition pt = new PathTransition(Duration.millis(800), pentagon, rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();
        // Create fade transition
        FadeTransition ft = new FadeTransition(Duration.millis(600), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        // Mouse functions
        pentagon.setOnMouseClicked(e -> togglePlaying(pt, ft));
        // Create scene
        stackPane.getChildren().addAll(pentagon, rectangle);
        Scene scene = new Scene(stackPane, 500, 350);
        primaryStage.setTitle("Moving Pentagon!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
