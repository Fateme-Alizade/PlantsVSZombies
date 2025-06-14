package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Repeater extends PeaPlants{
    private AnchorPane anchorPane;
    private ImageView imageView;
    private List<Image> frames;
    private Timeline timeline;
    private int frameIndex = 0;
    private double x,y;

    public Repeater(AnchorPane anchorPane , double x , double y){
        super(4,7.5,200);
        imageView = new ImageView();
        frames = new ArrayList<>();
        this.anchorPane = anchorPane;
        this.x = x ;
        this.y = y ;
        getImage();
    }

    @Override
    void shooting() {
        Bullet bullet1 = new Bullet(x - 140 ,y+230, anchorPane);
        Bullet bullet2 = new Bullet(x-120,y+230, anchorPane);
        bullet1.play();
        bullet2.play();
    }

    public void getImage() {
        for (int i = 0; i <= 13; i++) {
            Image image = new Image(getClass().getResourceAsStream("/images/Repeater/RepeaterPea_" + i + ".png"));
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