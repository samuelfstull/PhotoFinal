package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;


public class EditorController {
    ImageView myImageView;
    @FXML AnchorPane editorPane;
    private int counter = 0;
    public void btnLoadEventListener(ActionEvent actionEvent) {

            FileChooser fileChooser = new FileChooser();


            //Set extension filter
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                System.out.println("test");
                addPhotoToFolder();
                //myImageView.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


        private void addPhotoToFolder(){
        }
        private void addPhotos(){

        TextArea test = new TextArea();
        AnchorPane.setBottomAnchor(test, 10.0+counter);
        editorPane.getChildren().add(test);



        }

    public void testButton(ActionEvent actionEvent) {
        addPhotos();
        System.out.println("test1");
    }
}
