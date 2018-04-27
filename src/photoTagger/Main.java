package photoTagger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Tu-Tu Tango Studios");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }

    static ArrayList<PhotoInstance> allPhotos = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }
}