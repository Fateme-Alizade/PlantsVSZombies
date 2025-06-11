package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Level1Controller {
    @FXML private ImageView cardimage1;
    @FXML private ImageView cardimage2;
    @FXML private GridPane gridPane;
    @FXML private ToggleButton toggleButton1;
    @FXML private ToggleButton toggleButton2;
    @FXML
    private void initialize() {
        Image image = new Image(getClass().getResource("/images/Peashooter/card.png").toExternalForm());
        cardimage1.setImage(image);
        cardimage2.setImage(image);
        if (image.isError()) System.out.println("Error"+image.getException());
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                Button button = new Button();
                button.getStyleClass().add("cell");
                button.setPrefSize(85, 105);
                gridPane.add(button, col, row);
            }
        }
        setUpToggleButtons();
    }

    private void setUpToggleButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                ToggleButton selectedToggleButton = (ToggleButton) newValue;
            }

        });
    }


}
