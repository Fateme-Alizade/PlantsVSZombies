package org.example;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class WallNut extends NutPlants{
    public WallNut(int HP, double RechargeTime, int SunPrice) {
        super(HP, RechargeTime, SunPrice);
    }

    private ImageView imageView;
    private List<Image> frames;
    private Timeline timeline;
    private int frameIndex = 0;

    public WallNut(){
        super(4,7.5,50);
        imageView = new ImageView();
        frames = new ArrayList<>();
        getImage();
    }
    public void getImage() {
        for (int i = 0; i <= 14; i++) {
            Image image = new Image(getClass().getResourceAsStream("/images/WallNut/WallNut/WallNut_" + i + ".png"));
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
