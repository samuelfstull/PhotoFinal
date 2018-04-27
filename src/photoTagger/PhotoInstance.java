package photoTagger;

import javafx.scene.image.Image;

import java.util.ArrayList;

class PhotoInstance {

    private String name;
    private ArrayList<String> tags;
    private Image image;

    PhotoInstance(String name, ArrayList<String> tags, Image image) {
        this.name = name;
        this.tags = tags;
        this.image = image;
    }

    String getTags() {
        String intro = "tags: ";
        for (String i : tags){
            intro +=i;
        }
        return intro;
    }

    ArrayList<String>getTagList(){
        return tags;
    }

    Image getImage() {
        return image;
    }
}