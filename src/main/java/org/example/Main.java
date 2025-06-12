package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Scene scene;
    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("Welcome"), 1500, 1000);
        scene.getStylesheets().add(getClass().getResource("/css/Style.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Welcome");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static Scene getScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}