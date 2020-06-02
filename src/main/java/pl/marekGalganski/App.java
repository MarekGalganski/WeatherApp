package pl.marekGalganski;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            Parent grid = FXMLLoader.load(getClass().getResource("/view.fxml"));

            primaryStage.setTitle("DoubleWeatherApp");

            Scene scene = new Scene(grid, 900, 575);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}