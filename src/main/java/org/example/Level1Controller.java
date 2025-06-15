package org.example;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.List;

public class Level1Controller {

    @FXML private ImageView cardimage0;
    @FXML private ImageView cardimage1;
    @FXML private ImageView cardimage2;
    @FXML private ImageView cardimage3;
    @FXML private ImageView cardimage4;
    @FXML private ImageView cardimage5;
    @FXML private GridPane gridPane;
    @FXML private ToggleButton toggleButton0;
    @FXML private ToggleButton toggleButton1;
    @FXML private ToggleButton toggleButton2;
    @FXML private ToggleButton toggleButton3;
    @FXML private ToggleButton toggleButton4;
    @FXML private ToggleButton toggleButton5;
    @FXML public AnchorPane anchorPane;
    @FXML private Label label;
    public int currentPlant=-1;
    public static int score;


    @FXML
    private void initialize() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                Button button = new Button();
                button.getStyleClass().add("cell");
                button.setPrefSize(85, 105);
                button.setOnAction(even -> {
                    if(currentPlant != -1){
                        Planting.planting(button,currentPlant,anchorPane);
                    }
                });
                gridPane.add(button, col, row);
            }
        }
        setUpToggleButtons();
        selectToggleButtons();
        SunManager sunManager = new SunManager(anchorPane);
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> addScore()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void addScore() {
        label.setText(String.valueOf(score));
    }

    private void setUpToggleButtons() {
        List<ImageView> buttonImages = Arrays.asList(cardimage0,cardimage1,cardimage2,cardimage3,cardimage4,cardimage5);
        for (int i = 0; i < PlantsList1Controller.plants.size(); i++) {
            String imageName = null;
            switch (PlantsList1Controller.plants.get(i)) {
                case 0:
                    imageName = "/images/card/peashooter.jpg";
                    break;
                case 1:
                    imageName ="/images/card/repeater.jpg";
                    break;
                case 2:
                    imageName = "/images/card/snowPea.jpg";
                    break;
                case 3:
                    imageName = "/images/card/wallNut.jpg";
                    break;
                case 4:
                    imageName = "/images/card/tallNut.jpg";
                    break;
                case 5:
                    imageName = "/images/card/cherryBomb.jpg";
                    break;
                case 6:
                    imageName = "/images/card/jalapeno.jpg";
                    break;
                case 7:
                    imageName = "/images/card/sunflower.jpg";
                    break;
            }
            if(imageName != null){
                Image image = new Image(getClass().getResource(imageName).toExternalForm());
                buttonImages.get(i).setImage(image);
            }
        }
    }

    private void selectToggleButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton0.setToggleGroup(toggleGroup);
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleButton3.setToggleGroup(toggleGroup);
        toggleButton4.setToggleGroup(toggleGroup);
        toggleButton5.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                ToggleButton selectedToggleButton = (ToggleButton) newValue;
                String id = selectedToggleButton.getId();
                String[] parts = id.split("\\D+");
                String numberStr = parts[1];
                int number= Integer.parseInt(numberStr);
                currentPlant=PlantsList1Controller.plants.get(number);
            }
            else currentPlant=-1;
        });
    }
}
