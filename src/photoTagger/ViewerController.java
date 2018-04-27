package photoTagger;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ViewerController {
    public javafx.scene.control.TextField searchField;
    @FXML AnchorPane editorPane;
    private ArrayList<HBox> hBoxes = new ArrayList<>();
    private ArrayList<ImageView> imageViews = new ArrayList<>();


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
                imageHolderV.getChildren().add(hBoxes.get(currentFloor));
            }

        }

    }

    public void testButton() {
        addPhotos(Main.allPhotos);
    }
    private ArrayList<PhotoInstance> Searchedphotos(String searchTerm){
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

    public void searchFunction() {
        addPhotos(Searchedphotos(searchField.getText()));

    }
}
