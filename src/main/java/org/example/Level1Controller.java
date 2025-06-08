package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Level1Controller {
    @FXML
    private GridPane gridPane;
    @FXML
    private void initialize() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 9; col++) {
                Button button = new Button();
                button.setStyle("-fx-background-color: transparent;");
                button.setPrefSize(100, 120);
                gridPane.add(button, col, row);
            }
        }
    }
}
