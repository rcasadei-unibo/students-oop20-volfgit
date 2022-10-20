package vg.utils;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ImageFXUtils {

    public static void createImagePatternFrom(String pathImage){
        Image image = new Image(pathImage);
        new ImagePattern(image);
    }
}
