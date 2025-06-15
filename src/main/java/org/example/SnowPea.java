package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class SnowPea extends PeaPlants{
    private ImageView imageView;
    private List<Image> frames;
    private Timeline timeline;
    private int frameIndex = 0;
    private AnchorPane anchorPane;
    private double x,y;

    public SnowPea(AnchorPane anchorPane,double x,double y) {
        super(4,7.5,175);
        imageView = new ImageView();
        frames = new ArrayList<>();
        getImage();
        this.x = x;
        this.y = y;
        this.anchorPane = anchorPane;
    }


    @Override
    void shooting() {
        Bullet bullet = new Bullet(x-120,y+230,anchorPane,true);
        bullet.play();
    }

    public void getImage() {
        for (int i = 0; i <= 13; i++) {
            Image image = new Image(getClass().getResourceAsStream("/images/SnowPea/SnowPea_" + i + ".png"));
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
