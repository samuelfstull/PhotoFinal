package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class EditorController {
    ImageView myImageView;
    @FXML AnchorPane editorPane;
    private int counter = 0;
   private TextArea[] textAreas = new TextArea[10];

    public void choosePhoto(ActionEvent actionEvent) {

        FileChooser fileChooser = new FileChooser();

        //start recently added
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter extFilterPNG = new FileNameExtensionFilter("PNG files (*.png)", "*.PNG");
        chooser.setFileFilter(extFilterPNG);
        FileNameExtensionFilter extFilterJPG = new FileNameExtensionFilter("JPG files (*.jpg)", "*.JPG");
        chooser.setFileFilter(extFilterJPG);
        chooser.showOpenDialog(null);
        File[] files = chooser.getSelectedFiles();
        for(int i=0; i<files.length; i++) {
            String name = files[i].getName();
            String location = files[i].getAbsolutePath();
            try {
                BufferedImage bufferedImage = ImageIO.read(files[i]);

                System.out.println(bufferedImage.getHeight());
                System.out.println(bufferedImage.getWidth());

                BufferedImage bImage = scale(bufferedImage, 300, 225);
                //BufferedImage bImage = scale(bufferedImage, 100, 75);

                RenderedImage rImage = (RenderedImage) bImage;
                Image image = SwingFXUtils.toFXImage(bImage, null);

                makePhotoInstance(name, QuestionsController.tags, image);

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
        //end recently added
/*
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
            //BufferedImage bImage = scale(bufferedImage, 100, 75);

            RenderedImage rImage = (RenderedImage) bImage;
            Image image = SwingFXUtils.toFXImage(bImage, null);

            makePhotoInstance(name, QuestionsController.tags, image);

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

        //makePhotoInstance(name, QuestionsController.tags, rImage);
*/
    }


        private void addPhotoToFolder(){
        }
        private void addPhotos(){
    /*
        TextArea test = new TextArea();
        AnchorPane.setBottomAnchor(test, 10.0+counter);
        editorPane.getChildren().add(test);*/
            for( int i=0; i < 9; i++){
                double counterd = (double) counter;
                textAreas[i] =  new TextArea();     // <-- here
                textAreas[i].setText("testing 1,2,5"+counter);
                System.out.println(textAreas[i].getText());
                editorPane.getChildren().addAll((textAreas[i]));
                AnchorPane.setBottomAnchor(textAreas[i], counterd*10);
                counter++;
            }


        }

    public void testButton(ActionEvent actionEvent) {
        addPhotos();
        System.out.println("test1");
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
