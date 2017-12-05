package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(final Stage primaryStage) {
        try {
            final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Regex.fxml"));
            final Pane root = fxmlLoader.load();
            final Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Regex");
            primaryStage.show();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(final String[] args) {
        launch(args);
    }
}
