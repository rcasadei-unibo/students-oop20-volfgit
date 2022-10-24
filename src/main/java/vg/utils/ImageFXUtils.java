package vg.utils;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class ImageFXUtils {
    public static ImagePattern createImagePatternFrom(final String pathImage) {
        final Image image = new Image(pathImage);
        return new ImagePattern(image);
    }
}
