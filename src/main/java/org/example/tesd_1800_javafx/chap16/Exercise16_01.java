package org.example.tesd_1800_javafx.chap16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Exercise16_01 extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("Programming is... fun");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Text text = new Text(50, 50, "Programming is fun");
    public Font font = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 20);

    public BorderPane getPane() {
        text.setFont(font);
        HBox radioPane = new HBox(20);
        RadioButton[] rb = new RadioButton[]{new RadioButton("Red"),
                new RadioButton("Yellow"), new RadioButton("Black"),
                new RadioButton("Orange"), new RadioButton("Green")};
        ToggleGroup group = new ToggleGroup();
        for (int i = 0; i < 5; i++) {
            radioPane.getChildren().add(rb[i]);
            rb[i].setToggleGroup(group);
        }
        rb[0].setOnAction(e -> text.setStroke(Color.RED));
        rb[1].setOnAction(e -> text.setStroke(Color.YELLOW));
        rb[2].setOnAction(e -> text.setStroke(Color.BLACK));
        rb[3].setOnAction(e -> text.setStroke(Color.ORANGE));
        rb[4].setOnAction(e -> text.setStroke(Color.GREEN));

        rb[2].setSelected(true);
        radioPane.setAlignment(Pos.CENTER);
        radioPane.setStyle("-fx-border-width: 2px; -fx-border-color: black");
        radioPane.setPadding(new Insets(5, 5, 5, 5));

        HBox buttonPane = new HBox(20);
        Button btL = new Button("<- Left");
        Button btR = new Button("Right ->");
        buttonPane.getChildren().addAll(btL, btR);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setStyle("-fx-border-width: 2px; -fx-border-color: black");
        buttonPane.setPadding(new Insets(5, 5, 5, 5));

        btL.setOnAction(e -> move(buttonPane, text, -10));
        btR.setOnAction(e -> move(buttonPane, text, 10));

        Pane textPane = new Pane();
        textPane.getChildren().add(text);
        textPane.setStyle("-fx-border-width: 2px; -fx-border-color: black");
        textPane.setPadding(new Insets(5, 5, 5, 5));
        text.setStroke(Color.BLACK);

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setTop(radioPane);
        pane.setBottom(buttonPane);

        return pane;
    }

    public static void move(Pane pane, Text text, int num) {
        double targetX = text.getX() + num;
        if (targetX < 0)
            text.setX(0);
        else if (targetX > pane.getWidth() - 190)
            text.setX(pane.getWidth() - 190);
        else
            text.setX(targetX);
    }
}
