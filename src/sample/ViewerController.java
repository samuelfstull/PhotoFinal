package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedReader;
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


public class ViewerController {
    ImageView myImageView = new ImageView();
    @FXML AnchorPane editorPane;
    private int counter = 1;
   //private TextArea[] textAreas = new TextArea[10];
   private ArrayList<TextArea> textAreas = new ArrayList<>();
    private ArrayList<HBox> hBoxes = new ArrayList<>();

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


        private void addPhotoToFolder(){
        }



        private void addPhotos(){
            VBox imageHolderV = new VBox();
            editorPane.getChildren().addAll((imageHolderV));
            textAreas.add(new TextArea());

            for( int i=1; i < 10; i++){
                textAreas.add(new TextArea());
                int currentFloor = (int)Math.floor(i/3);
                if (currentFloor==i/3){
                    hBoxes.add(new HBox());
                }

                textAreas.get(i).setText("testing 1,2,5! NUMBER: "+i);
                hBoxes.get(currentFloor).getChildren().addAll(textAreas.get(i));
                if (i%3==0|| i==1){
                    System.out.println(currentFloor);
                imageHolderV.getChildren().add(hBoxes.get(currentFloor));
                }

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
