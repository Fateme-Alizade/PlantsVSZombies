package org.example;

import javafx.scene.control.Button;

public class Planting {
    public static void planting(Button button, int plantId) {
        switch (plantId) {
            case 0: {
                Peashooter peashooter = new Peashooter();
                button.setGraphic(peashooter.getImageView());
                peashooter.playAnimation();
                break;
            }
            // مثال برای یکی دیگه:
            /*
            case 1: {
                Repeater repeater = new Repeater();
                button.setGraphic(repeater.getImageView());
                repeater.playAnimation();
                break;
            }
            */
            default:
                System.out.println("کد گیاه نامعتبر است: " + plantId);
        }
    }
}