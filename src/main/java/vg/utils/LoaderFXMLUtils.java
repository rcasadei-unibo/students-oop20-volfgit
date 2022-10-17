package vg.utils;

import javafx.fxml.FXMLLoader;

public class LoaderFXMLUtils {

    public static FXMLLoader GetLoader(String path) {
       return new FXMLLoader(LoaderFXMLUtils.class.getResource("/layout/GameBoard1.fxml"));
    }
}
