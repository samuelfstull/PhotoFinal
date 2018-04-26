package sample;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.lang.reflect.Array;
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

    public ArrayList<String> getTags() {
        return tags;
    }

    public Image getImage() {
        return image;
    }
}