package org.example.tesd_1800_javafx.chap15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_L extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        // Create main panel
        BorderPane borderPane = new BorderPane();
        // Create ball
        BallPane ballPane = new BallPane();
        borderPane.setCenter(ballPane);
        // Create buttons
        Button butU = new Button("Up");
        Button butD = new Button("Down");
        Button butL = new Button("Left");
        Button butR = new Button("Right");
        HBox hBox = new HBox(butU, butD, butL, butR);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setSpacing(5);
        borderPane.setBottom(hBox);
        // Button lambdas
        butU.setOnAction(e -> { ballPane.move("up"); });
        butD.setOnAction(e -> { ballPane.move("down"); });
        butL.setOnAction(e -> { ballPane.move("left"); });
        butR.setOnAction(e -> { ballPane.move("right"); });
        // Create scene
        Scene scene = new Scene(borderPane, 250, 150);
        primaryStage.setTitle("Moving Ball!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class BallPane extends Pane {
        //attributes
        private Circle circle = new Circle(50, 50, 20);

        //constructors
        public BallPane() {
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.SLATEGRAY);
            circle.setStrokeWidth(0.3);
            getChildren().add(circle);
        }

        //accessors

        //mutators

        //methods
        public void move(String direction) {
            double targetX = circle.getCenterX();
            double targetY = circle.getCenterY();
            switch (direction) {
                case "up": targetY -= 10.0; break;
                case "down": targetY += 10.0; break;
                case "left": targetX -= 10.0; break;
                case "right": targetX += 10.0; break;
            }
            if ((targetY < 20 || targetY > getHeight() - circle.getRadius()) ||
                    (targetX < 20 || targetX > getWidth() - circle.getRadius())) //if out of bounds
                return;
            circle.setCenterX(targetX);
            circle.setCenterY(targetY);
        }

        //initializers

        //printers
    }
}
