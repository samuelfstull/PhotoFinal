package photoTagger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        primaryStage.setTitle("Tu-Tu Tango Studios");
        primaryStage.setScene(new Scene(root, 700, 275));
        primaryStage.show();
    }

    //HashMap<PhotoInstance, Photo> hmap = new HashMap<PhotoInstance, Photo>();

    //HashMap<Object, Object> hmap = new HashMap<Object, Object>();

    public static ArrayList<PhotoInstance> allPhotos = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }

    public Image getImage(PhotoInstance pi) {
        return pi.getImage();
    }
}





/*
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.ViewStage.FileChooser;
import javafx.ViewStage.Stage;
import javax.imageio.ImageIO;

/**
 * @web http://java-buddy.blogspot.com/

public class Main extends Application {

}


    ImageView myImageView;

    @Override
    public void start(Stage primaryStage) {

        Button btnLoad = new Button("Load");
        btnLoad.setOnAction(btnLoadEventListener);

        myImageView = new ImageView();

        VBox rootBox = new VBox();
        rootBox.getChildren().addAll(btnLoad, myImageView);

        Scene scene = new Scene(rootBox, 300, 300);

        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    EventHandler<ActionEvent> btnLoadEventListener
            = new EventHandler<ActionEvent>(){

        @Override
        public void handle(ActionEvent t) {
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
                myImageView.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    };
*/