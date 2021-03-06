package photoTagger;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class MainMenuController {
    private Stage ViewStage = new Stage();
    private Stage Editstage = new Stage();
    public void photoViewerPress() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("questions.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ViewStage.setTitle("Add your Photos!");
        ViewStage.setScene(new Scene(root, 650, 450));
        ViewStage.show();
    }


    public void PhotoAdderPress() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("photoViewer.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Editstage.setTitle("View your Photos!");
        Editstage.setScene(new Scene(root, 1100, 765));
        Editstage.show();
    }
}
