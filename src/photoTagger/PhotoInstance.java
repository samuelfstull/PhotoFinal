package photoTagger;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class PhotoInstance {

    private String name;
    private ArrayList<String> tags;
    private Image image;

    public PhotoInstance(String name, ArrayList<String> tags, Image image) {
        this.name = name;
        this.tags = tags;
        this.image = image;
        //image1 = this.image;
    }

    public String getTags() {
        String intro = "tags: ";
        for (String i : tags){
            intro +=i;
        }
        return intro;
    }
    public ArrayList<String>getTagList(){
        return tags;
    }

    public Image getImage() {
        return image;
    }
}