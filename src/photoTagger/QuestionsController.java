package photoTagger;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    @FXML private javafx.scene.control.Button closeWindow;

    private ArrayList<String> tags = new ArrayList<>();


    public void choosePhoto() {
        Stage stage = (Stage) closeWindow.getScene().getWindow();
        stage.close();

        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(null);
        File[] files = chooser.getSelectedFiles();

        tags.clear();
        tags.add(whenText.getText());
        tags.add(otherText.getText());
        tags.add(whereText.getText());
        for(int i=0; i<files.length; i++) {
            String name = files[i].getName();
            try {
                BufferedImage bufferedImage = ImageIO.read(files[i]);

                BufferedImage bImage = scale(bufferedImage);

                Image image = SwingFXUtils.toFXImage(bImage, null);

                makePhotoInstance(name, tags, image);


            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        QuestionsController.infoBox(files.length + " photos added.", "SUCCESS!");
    }


    private static BufferedImage scale(BufferedImage src)
    {
        BufferedImage img =
                new BufferedImage(300, 225, BufferedImage.TYPE_INT_RGB);
        int x, y;
        int ww = src.getWidth();
        int hh = src.getHeight();
        int[] ys = new int[225];
        for (y = 0; y < 225; y++)
            ys[y] = y * hh / 225;
        for (x = 0; x < 300; x++) {
            int newX = x * ww / 300;
            for (y = 0; y < 225; y++) {
                int col = src.getRGB(newX, ys[y]);
                img.setRGB(x, y, col);
            }
        }
        return img;
    }

    private void makePhotoInstance(String name, ArrayList<String> tags, Image image) {
        PhotoInstance newPI = new PhotoInstance(name, tags, image);
        Main.allPhotos.add(newPI);
    }

    private static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
