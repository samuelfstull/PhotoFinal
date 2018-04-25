import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PhotoInstance {

    public String name;
    public String[] tags;

    public PhotoInstance(String name, String[] tags) {
        name = this.name;
        tags = this.tags;
    }

    ArrayList<String> tagList;
    PhotoInstance(ArrayList<String> tags){
    tagList = tags;
    }
}

