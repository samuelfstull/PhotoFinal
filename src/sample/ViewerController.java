package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javafx.scene.*;

import javafx.scene.layout.Region;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;


public class ViewerController {
    @FXML AnchorPane editorPane;
    private ArrayList<TextArea> textAreas = new ArrayList<>();
    private ArrayList<HBox> hBoxes = new ArrayList<>();
    private ArrayList<ImageView> imageViews = new ArrayList<>();

    public void btnLoadEventListener(ActionEvent actionEvent) {

            FileChooser fileChooser = new FileChooser();


            //Set extension filter
            FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
            FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
            fileChooser.getExtensionFilters().addAll(extFilterPNG, extFilterJPG);

            //Show open file dialog
            File file = fileChooser.showOpenDialog(null);

            try {
                BufferedImage bufferedImage = ImageIO.read(file);

                System.out.println(bufferedImage.getHeight());
                System.out.println(bufferedImage.getWidth());

                BufferedImage bImage = scale(bufferedImage, 300, 225);

                RenderedImage rImage = (RenderedImage) bImage;

                try {
                    System.out.println("got here");
                    File outputfile = new File("C:\\Users\\Adam\\Pictures\\saved.png");

                    ImageIO.write(rImage, "png", outputfile);
                } catch(IOException e) {
                    System.out.println("Write error!");
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
/*
        private void addPhotos() {
            GridPane gridPane = new GridPane();
            //Insets inset = new Insets(5,5,5,5);
            gridPane.setPadding(new Insets(5,5,5,5));
            gridPane.setHgap(10);
            gridPane.setVgap(10);

            final ImageView imv = new ImageView();
            final Image image2 = new Image(Main.class.getResourceAsStream("saved.png"));
            imv.setImage(image2);

            final HBox pictureRegion = new HBox();

            pictureRegion.getChildren().add(imv);
            gridPane.add(pictureRegion, 1, 1);
        }
*/
/*
        private void addPhotos(){
            Image img = Main.allPhotos.get(0).getImage();
            ImageView imgV = new ImageView(img);
            imgV.setImage(img);
            HBox picRegion = new HBox();
            picRegion.getChildren().addAll(imgV);

            System.out.println("Got to addPhotos");


            VBox imageHolderV = new VBox();
            editorPane.getChildren().addAll((imageHolderV));
            //imageViews.add(new ImageView());

            for( int i=0; i < Main.allPhotos.size(); i++){
                ImageView imv = new ImageView();
                Image pic = Main.allPhotos.get(i).getImage();
                imv.setImage(pic);
                imageViews.add(imv);
                int currentFloor = (int)Math.ceil(i/3);
                if (currentFloor==i/3){
                    hBoxes.add(new HBox());
                }

                //textAreas.get(i).setText("testing 1,2,5! NUMBER: "+i);
                hBoxes.get((i-1)/3).getChildren().addAll(imageViews.get(i));

                if (i%3==1){
                    System.out.println("test ");
                    imageHolderV.getChildren().add(hBoxes.get(currentFloor));
                }

            }

        }
*/
    private void addPhotos() {
        VBox imageHolderV = new VBox();
        editorPane.getChildren().addAll((imageHolderV));
        imageViews.add(new ImageView());

        for( int i=1; i <= Main.allPhotos.size(); i++){
            ImageView imv = new ImageView();
            imageViews.add(imv);
            int currentFloor = (int)Math.ceil(i/3);
            if (currentFloor==i/3){
                hBoxes.add(new HBox());
            }

            //Image image = new Image(file)

            System.out.println(Main.allPhotos.get(i-1));

            Image img = Main.allPhotos.get(i-1).getImage();
            imageViews.get(i).setImage(img);
            HBox hb = hBoxes.get((i-1)/3);
            hb.setPadding(new Insets(15, 12, 15, 12));
            hb.setSpacing(10);
            hb.getChildren().addAll(imageViews.get(i));

            if (i%3==1){
                System.out.println("test ");
                System.out.println(img);
                imageHolderV.getChildren().add(hBoxes.get(currentFloor));
            }

        }

    }

    public void testButton(ActionEvent actionEvent) {
        addPhotos();
        //Scene scene = new Scene(root, 600, 330, Color.WHITE);
    }

    public static BufferedImage scale(BufferedImage src, int w, int h)
    {
        BufferedImage img =
                new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[h];
        for (y = 0; y < h; y++)
            ys[y] = y * hh / h;
        for (x = 0; x < w; x++) {
            int newX = x * ww / w;
            for (y = 0; y < h; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }


}
