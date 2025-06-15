package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

public class Sun {
    private ImageView imageView;
    private List<Image> frames;
    private Timeline timeline;
    private int frameIndex = 0;
    private double RechargeTime;

    public  Sun() {
        imageView = new ImageView();
        frames = new ArrayList<>();
        getImage();
        RechargeTime = 10;
    }

    public void getImage() {
        for (int i = 0; i <= 21; i++) {
            Image image = new Image(getClass().getResourceAsStream("/images/Sun/Sun_" + i + ".png"));
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
}
