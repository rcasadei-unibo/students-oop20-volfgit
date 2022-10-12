package vg.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.File;
import java.io.IOException;

public class LoadFxmlUtils {
    public static Parent loadFxml(String relativePath){
        File file = new File("src/main/resources/" + relativePath);
        try {
            return FXMLLoader.load(file.toURI().toURL());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
