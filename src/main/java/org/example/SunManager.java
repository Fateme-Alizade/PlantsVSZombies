package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.util.Random;
import static org.example.Level1Controller.score;

public class SunManager {
    private AnchorPane gamePane;
    private Random random;
    private double x,y;


    public SunManager(AnchorPane gamePane) {
        this.gamePane = gamePane;
        this.random = new Random();
        startGeneratingSunFromSky();
    }

    public SunManager(AnchorPane gamePane, double x, double y) {
        this.gamePane = gamePane;
        this.x = x;
        this.y = y;
        startGeneratingSunFromFlower();
    }

    private void startGeneratingSunFromFlower(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> dropSunFromFlower()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void startGeneratingSunFromSky() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> dropSunFromSky()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void dropSunFromSky() {
        double x = 500 + random.nextDouble() * 400;
        double yStart = -80;
        double yEnd = 200 + random.nextDouble() * 200;

        Sun sun = new Sun();
        sun.getImageView().setLayoutX(x);
        sun.getImageView().setLayoutY(yStart);
        sun.playAnimation();
        gamePane.getChildren().add(sun.getImageView());

        TranslateTransition fall = new TranslateTransition(Duration.seconds(4), sun.getImageView());
        fall.setToY(yEnd);
        fall.play();

        sun.getImageView().setOnMouseClicked(event -> {
            gamePane.getChildren().remove(sun.getImageView());
            score += 25;
        });
    }

    private void dropSunFromFlower() {
        x= gamePane.getLayoutX();
        y= gamePane.getLayoutY();
        Sun sun = new Sun();
        sun.getImageView().setLayoutX(x);
        sun.getImageView().setLayoutY(y);
        sun.playAnimation();
        gamePane.getChildren().add(sun.getImageView());

        TranslateTransition fall = new TranslateTransition(Duration.seconds(4), sun.getImageView());
        fall.setToY(y);
        fall.play();

        sun.getImageView().setOnMouseClicked(event -> {
            gamePane.getChildren().remove(sun.getImageView());
            score += 25;
        });
    }
}