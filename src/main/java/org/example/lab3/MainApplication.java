package org.example.lab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Julius Jauga 5 gr. 1 pogr.
 * Main class of the application.
 */
public class MainApplication extends Application {
    /**
     * Start method.
     * @param stage
     * @throws IOException If the file does not open.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("input-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("input");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}