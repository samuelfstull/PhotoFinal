package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestionsController {

    @FXML private TextField whereText;
    @FXML private TextField whenText;
    @FXML private TextField otherText;

    ArrayList<String> tags = new ArrayList<>();

    @FXML
    private void getWhereText() {
        System.out.println("Got here!");
        String text = whereText.getText().toString();
        addTextToTags(text);
    }

    @FXML
    private void getWhenText() {
        String text = whenText.getText();
        addTextToTags(text);
    }

    @FXML
    private void getOtherText() {
        String text = otherText.getText();
        addTextToTags(text);
    }

    private void addTextToTags(String text) {
        tags.add(text);
        System.out.println(tags);
    }
    public void choosePhoto() {

        FileChooser fileChooser = new FileChooser();


        //Set extension filter
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        fileChooser.getExtensionFilters().addAll(extFilterPNG, extFilterJPG);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);
        String name = file.getName(); //gets the name of the image file, e.g. jacksonWashington1.png
        String location = file.getAbsolutePath();
        System.out.println("absolute path for this pic is: " + location);
        System.out.println(name);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);

            System.out.println(bufferedImage.getHeight());
            System.out.println(bufferedImage.getWidth());

            BufferedImage bImage = scale(bufferedImage, 300, 225);

            RenderedImage rImage = (RenderedImage) bImage;
            javafx.scene.image.Image image = SwingFXUtils.toFXImage(bImage, null);

            tags.clear();
            tags.add(whenText.getText());
            tags.add(whereText.getText());
            tags.add(otherText.getText());
            makePhotoInstance(name, tags, image);

            try {
                System.out.println("got here");
                File outputfile = new File("C:\\Users\\Adam\\Pictures\\" + name);

                ImageIO.write(rImage, "png", outputfile);
            } catch(IOException e) {
                System.out.println("Write error!");
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }



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

    private void makePhotoInstance(String name, ArrayList<String> tags, Image image) {
        PhotoInstance newPI = new PhotoInstance(name, tags, image);
        Main.allPhotos.add(newPI);

        //for debugging
        for(int i=0; i<Main.allPhotos.size(); i++) {
            System.out.println("printing PhotoInstance parameters: " + Main.allPhotos.get(i));
        }

        System.out.println(Main.allPhotos.size());
    }
}
