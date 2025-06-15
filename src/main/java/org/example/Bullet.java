package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Bullet {
    private static final Image BULLET_IMAGE = new Image(Bullet.class.getResource("/images/Bullets/PeaNormal/PeaNormal_0.png").toExternalForm());
    private static final Image SNOW_IMAGE = new Image(Bullet.class.getResource("/images/Bullets/PeaIce/PeaIce_0.png").toExternalForm());

    private ImageView imageView;
    private ImageView imageView2;
    private Timeline timeline;

    public Bullet(double startX, double startY, AnchorPane parentPane,Boolean isSnow) {
        if (isSnow) {
            imageView2 = new ImageView(SNOW_IMAGE);
            imageView2.setFitHeight(30);
            imageView2.setFitWidth(30);
            imageView2.setLayoutX(startX);
            imageView2.setLayoutY(startY);

            parentPane.getChildren().add(imageView2);
            timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
                imageView2.setLayoutX(imageView2.getLayoutX() + 5);

                if (imageView2.getLayoutX() > parentPane.getWidth()) {
                    stop();
                    parentPane.getChildren().remove(imageView2);
                }
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
        }
    }

    public Bullet(double startX, double startY, AnchorPane parentPane) {
        imageView = new ImageView(BULLET_IMAGE);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        imageView.setLayoutX(startX);
        imageView.setLayoutY(startY);

        parentPane.getChildren().add(imageView);

        timeline = new Timeline(new KeyFrame(Duration.millis(16), e -> {
            imageView.setLayoutX(imageView.getLayoutX() + 5);

            if (imageView.getLayoutX() > parentPane.getWidth()) {
                stop();
                parentPane.getChildren().remove(imageView);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void play() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    public ImageView getImageView() {
        return imageView;
    }
}
