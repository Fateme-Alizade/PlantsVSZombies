package org.example;

import javafx.scene.control.Button;

public class Planting {
    public static void planting(Button button, int plantId) {
        switch (plantId) {
            case 0:
                Peashooter peashooter = new Peashooter();
                button.setGraphic(peashooter.getImageView());
                peashooter.playAnimation();
                break;
            case 1:
                Repeater repeater = new Repeater();
                button.setGraphic(repeater.getImageView());
                repeater.playAnimation();
                break;
            case 2:
                SnowPea snowPea = new SnowPea();
                button.setGraphic(snowPea.getImageView());
                snowPea.playAnimation();
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
                Sunflower sunflower = new Sunflower();
                button.setGraphic(sunflower.getImageView());
                sunflower.playAnimation();
                break;
            default:
                System.out.println("کد گیاه نامعتبر است: " + plantId);
        }
    }
}