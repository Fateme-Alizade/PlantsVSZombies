package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static org.example.Level1Controller.score;

public class Sunflower extends AnotherPlants {

    private AnchorPane anchorPane;
    private double x, y;

    public Sunflower(AnchorPane anchorPane, double x, double y) {
        super(4, 7.5, 100);
        imageView = new ImageView();
        frames = new ArrayList<>();
        getImage();
        this.anchorPane = anchorPane;
        this.x = x - 120;
        this.y = y + 200;
    }

    public static ImageView getCardImage;
    private ImageView imageView;
    private List<Image> frames;
    private Timeline timeline;
    private int frameIndex = 0;

    public void getImage() {
        for (int i = 0; i <= 17; i++) {
            Image image = new Image(getClass().getResourceAsStream("/images/SunFlower/SunFlower_" + i + ".png"));
            frames.add(image);
        }
        imageView.setImage(frames.get(0));
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            frameIndex = (frameIndex + 1) % frames.size();
            imageView.setImage(frames.get(frameIndex));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void playAnimation() {
        timeline.play();
    }

    public void stopAnimation() {
        timeline.stop();
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void dropping() {
        Timeline sunTimeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
            Sun sun = new Sun();
            sun.getImageView().setLayoutX(x);
            sun.getImageView().setLayoutY(y);
            sun.playAnimation();
            anchorPane.getChildren().add(sun.getImageView());

            TranslateTransition fall = new TranslateTransition(Duration.seconds(2), sun.getImageView());
            fall.setToY(y-268);
            fall.play();

            sun.getImageView().setOnMouseClicked(event -> {
                anchorPane.getChildren().remove(sun.getImageView());
                score += 25;
            });
        }));
        sunTimeline.setCycleCount(Timeline.INDEFINITE);
        sunTimeline.play();
    }
}
