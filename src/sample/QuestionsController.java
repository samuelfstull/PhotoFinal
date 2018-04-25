package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionsController {

    @FXML private TextField whereText;
    @FXML private TextField whenText;
    @FXML private TextField otherText;
    @FXML private Button getStarted;

    protected static ArrayList<String> tags = new ArrayList<>();

    public void photoViewerPress(ActionEvent actionEvent) {

        Stage stage1 = (Stage) getStarted.getScene().getWindow();
        // do what you have to do
        stage1.close();


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("photoEditor.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Add your Photos!");
        stage.setScene(new Scene(root, 450, 450));
        stage.showAndWait();

        System.out.println(tags);



        //PhotoInstance photoInstance = new PhotoInstance()
    }

    @FXML
    private void getWhereText() {
        System.out.println("Got here!");
        String text = whereText.getText().toString();
        addTextToTags(text);
    }

    @FXML
    private void getWhenText() {
        String text = whenText.getText().toString();
        addTextToTags(text);
    }

    @FXML
    private void getOtherText() {
        String text = otherText.getText().toString();
        addTextToTags(text);
    }

    private void addTextToTags(String text) {
        tags.add(text);
        System.out.println(tags);
    }



}
