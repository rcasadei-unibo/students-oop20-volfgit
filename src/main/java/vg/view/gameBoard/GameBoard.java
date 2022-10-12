package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.utils.LoadFxmlUtils;

public class GameBoard extends Application {

    Rectangle rect = new Rectangle(100, 100, 100, 100);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));


        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();



    }
}

