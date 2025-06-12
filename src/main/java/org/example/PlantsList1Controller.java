package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;

public class PlantsList1Controller {
    public static ArrayList<Integer> plants;
    private Image image_0 =  new Image(getClass().getResource("/images/card/peashooter.jpg").toExternalForm());
    private Image image_1 =  new Image(getClass().getResource("/images/card/repeater.jpg").toExternalForm());
    private Image image_2 =  new Image(getClass().getResource("/images/card/snowPea.jpg").toExternalForm());
    private Image image_3 =  new Image(getClass().getResource("/images/card/wallNut.jpg").toExternalForm());
    private Image image_4 =  new Image(getClass().getResource("/images/card/tallNut.jpg").toExternalForm());
    private Image image_5 =  new Image(getClass().getResource("/images/card/cherryBomb.jpg").toExternalForm());
    private Image image_6 =  new Image(getClass().getResource("/images/card/jalapeno.jpg").toExternalForm());
    private Image image_7 =  new Image(getClass().getResource("/images/card/sunflower.jpg").toExternalForm());

    @FXML private ToggleButton toggle0;
    @FXML private ToggleButton toggle1;
    @FXML private ToggleButton toggle2;
    @FXML private ToggleButton toggle3;
    @FXML private ToggleButton toggle4;
    @FXML private ToggleButton toggle5;
    @FXML private ToggleButton toggle6;
    @FXML private ToggleButton toggle7;
    @FXML private ImageView peashooter;
    @FXML private ImageView repeater;
    @FXML private ImageView snowPea;
    @FXML private ImageView wallNut;
    @FXML private ImageView tallNut;
    @FXML private ImageView cherryBomb;
    @FXML private ImageView jalapeno;
    @FXML private ImageView sunflower;


    private int selectedCount = 0;

    public PlantsList1Controller() {
        plants = new ArrayList<>();
    }

    @FXML
    private void initialize() {
        addToggleLogic(toggle0);
        addToggleLogic(toggle1);
        addToggleLogic(toggle2);
        addToggleLogic(toggle3);
        addToggleLogic(toggle4);
        addToggleLogic(toggle5);
        addToggleLogic(toggle6);
        addToggleLogic(toggle7);
        peashooter.setImage(image_0);
        repeater.setImage(image_1);
        snowPea.setImage(image_2);
        wallNut.setImage(image_3);
        tallNut.setImage(image_4);
        cherryBomb.setImage(image_5);
        jalapeno.setImage(image_6);
        sunflower.setImage(image_7);
    }

    private void addToggleLogic(ToggleButton toggle) {
        String id = toggle.getId();
        String[] parts = id.split("\\D+");
        String numberStr = parts[1];
        int number = Integer.parseInt(numberStr);
        toggle.setOnAction(event -> {
            if (toggle.isSelected()) {
                if (selectedCount < 6) {
                    selectedCount++;
                    plants.add(number);
                } else {
                    toggle.setSelected(false);
                }
            } else {
                selectedCount--;
                plants.remove(Integer.valueOf(number));
            }
        });
    }

    @FXML
    private void switchToLevel1() throws IOException {
        if (selectedCount == 6) {
            Main.setRoot("Level1");
        }
    }
}