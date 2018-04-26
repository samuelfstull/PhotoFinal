package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ViewerController {
    public javafx.scene.control.TextField searchField;
    @FXML AnchorPane editorPane;
    private ArrayList<HBox> hBoxes = new ArrayList<>();
    private ArrayList<ImageView> imageViews = new ArrayList<>();
    private ArrayList<Label> tagLabels = new ArrayList<>();


    private void addPhotos(ArrayList<PhotoInstance> photoList ) {

        imageViews.clear();
        hBoxes.clear();
        editorPane.getChildren().clear();
        VBox imageHolderV = new VBox();
        editorPane.getChildren().setAll((imageHolderV));
        imageViews.add(new ImageView());

        for( int i=1; i <= photoList.size(); i++){
            javafx.scene.control.Label label = new javafx.scene.control.Label();
            VBox holder = new VBox();
            //tagLabels.add(lab);                          //all tag labels added in here
            ImageView imv = new ImageView();
            imageViews.add(imv);
            int currentFloor = (int)Math.ceil(i/3);
            if (currentFloor==i/3){
                hBoxes.add(new HBox());
            }

            //System.out.println(photoList.get(i-1));
            Image img = photoList.get(i-1).getImage();
            imageViews.get(i).setImage(img);

            HBox hb = hBoxes.get((i-1)/3);
            hb.setPadding(new Insets(15,12,15,12));
            hb.setSpacing(10);
            label.setText(photoList.get(i-1).getTags());
            label.setTextFill(Color.web("#ffffff"));
            label.setFont(new Font("Cambria", 20));
            holder.getChildren().addAll(imageViews.get(i),label);
            hb.getChildren().addAll(holder);

            if (i%3==1){
                System.out.println("test ");
                System.out.println(img);
                imageHolderV.getChildren().add(hBoxes.get(currentFloor));
            }

        }

    }

    public void testButton(ActionEvent actionEvent) {
        addPhotos(Main.allPhotos);
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
    public ArrayList<PhotoInstance> Searchedphotos(String searchTerm){
        ArrayList<PhotoInstance> listofPhotos = new ArrayList<>();
        for (PhotoInstance i:Main.allPhotos){
            for(String j: i.getTagList()){
                if (j.equals(searchTerm)){
                    listofPhotos.add(i);
                }
            }
        }
        return listofPhotos;
    }

    public void searchFunction(ActionEvent actionEvent) {
        addPhotos(Searchedphotos(searchField.getText()));

    }
    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
