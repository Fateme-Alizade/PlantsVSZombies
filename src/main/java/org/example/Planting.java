package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Planting {

    public static void planting(Button button , int current , AnchorPane anchorPane){
        double x = button.getLayoutX();
        double y = button.getLayoutY();
        Timeline timeline;
        switch (current) {
            case 0:
                Peashooter peashooter = new Peashooter(anchorPane , x , y);
                button.setGraphic(peashooter.getImageView());
                peashooter.playAnimation();
                timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> peashooter.shooting()));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                break;
            case 1:
                Repeater repeater = new Repeater(anchorPane,x,y);
                button.setGraphic(repeater.getImageView());
                repeater.playAnimation();
                timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> repeater.shooting()));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                break;
            case 2:
                SnowPea snowPea = new SnowPea(anchorPane,x,y);
                button.setGraphic(snowPea.getImageView());
                snowPea.playAnimation();
                timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> snowPea.shooting()));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                break;
            case 3:
                WallNut wallNut = new WallNut();
                button.setGraphic(wallNut.getImageView());
                wallNut.playAnimation();
                break;
            case 4:
                break;
            case 5:
                CherryBomb cherryBomb = new CherryBomb();
                button.setGraphic(cherryBomb.getImageView());
                cherryBomb.playAnimation();
                break;
            case 6:
                Jalapeno jalapeno = new Jalapeno();
                button.setGraphic(jalapeno.getImageView());
                jalapeno.playAnimation();
                break;
            case 7:
                Sunflower sunflower = new Sunflower(anchorPane,x,y);
                button.setGraphic(sunflower.getImageView());
                sunflower.playAnimation();
                timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> sunflower.dropping()));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();
                break;
        }
    }
}