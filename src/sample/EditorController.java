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
import java.util.Collection;
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
   private TextArea[] textAreas = new TextArea[10];

    public void choosePhoto(ActionEvent actionEvent) {

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
}
