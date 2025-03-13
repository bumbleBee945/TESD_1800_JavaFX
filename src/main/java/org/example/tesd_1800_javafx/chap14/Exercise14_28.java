package org.example.tesd_1800_javafx.chap14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise14_28 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create clock
        ClockPane clock = new ClockPane();
        // Assignment - second invisible, hour 0-11, minute 0 or 30
        clock.setSecondVisible(false);
        clock.setHour((int)(Math.random() * 12));
        clock.setMinute((int)(Math.random() * 2) * 30); // 0-1 -> 0 or 30
        // Create label
        String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        // Place clock and label in border pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DisplayClock"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}

class ClockPane extends Pane {
    //attributes
    private int hour;
    private int minute;
    private int second;
    private boolean hourVisible;
    private boolean minuteVisible;
    private boolean secondVisible;

    //constructors
    public ClockPane() {
        setCurrentTime();
        this.hourVisible = true;
        this.minuteVisible = true;
        this.secondVisible = true;
    }
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.hourVisible = true;
        this.minuteVisible = true;
        this.secondVisible = true;
    }
    public ClockPane(int hour, int minute, int second,
                     boolean hourVisible, boolean minuteVisible, boolean secondVisible) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.hourVisible = hourVisible;
        this.minuteVisible = minuteVisible;
        this.secondVisible = secondVisible;
    }

    //accessors
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public int getSecond() { return second; }
    public boolean isHourVisible() { return hourVisible; }
    public boolean isMinuteVisible() { return minuteVisible; }
    public boolean isSecondVisible() { return secondVisible; }

    //mutators
    public void setHour(int hour) { this.hour = hour; paintClock(); }
    public void setMinute(int minute) { this.minute = minute; paintClock(); }
    public void setSecond(int second) { this.second = second; paintClock(); }
    public void setHourVisible(boolean hourVisible) { this.hourVisible = hourVisible; paintClock(); }
    public void setMinuteVisible(boolean minuteVisible) { this.minuteVisible = minuteVisible; paintClock(); }
    public void setSecondVisible(boolean secondVisible) { this.secondVisible = secondVisible; paintClock(); }
    @Override
    public void setWidth(double width) { super.setWidth(width); paintClock(); }
    @Override
    public void setHeight(double height) { super.setHeight(height); paintClock(); }

    //methods
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        paintClock();
    }

    //initializers

    //printers
    private void paintClock() {
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        double hLength = clockRadius * 0.8;
        double handX = centerX + hLength * Math.sin(second * (2 * Math.PI / 60));
        double handY = centerY - hLength * Math.cos(second * (2 * Math.PI / 60));
        if (!secondVisible) { handX = centerX; handY = centerY; }
        Line sLine = new Line(centerX, centerY, handX, handY);
        hLength = clockRadius * 0.65;
        handX = centerX + hLength * Math.sin(minute * (2 * Math.PI / 60));
        handY = centerY - hLength * Math.cos(minute * (2 * Math.PI / 60));
        if (!minuteVisible) { handX = centerX; handY = centerY; }
        Line mLine = new Line(centerX, centerY, handX, handY);
        hLength = clockRadius * 0.5;
        handX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        handY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        if (!hourVisible) { handX = centerX; handY = centerY; }
        Line hLine = new Line(centerX, centerY, handX, handY);
        sLine.setStroke(Color.RED);
        mLine.setStroke(Color.BLUE);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
    }
}
