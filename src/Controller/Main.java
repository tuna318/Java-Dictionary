package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage parentWindow;
    @Override
    public void start(Stage stage) {
        try {
            parentWindow = stage;
            Parent root = FXMLLoader.load(getClass().getResource("../View/Dictionary.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Dictionary");
            stage.setScene(scene);
            stage.show();
        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
