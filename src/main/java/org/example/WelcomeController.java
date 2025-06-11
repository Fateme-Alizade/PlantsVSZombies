package org.example;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private void switchToLevel1() throws IOException {
        Main.setRoot("PlantsList1");
    }
}
