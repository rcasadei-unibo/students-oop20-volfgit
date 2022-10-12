package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.utils.LoadFxmlUtils;

public class GameBoard extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rect = new Rectangle(100, 100, 100, 100);
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        stage.setTitle("Ti pregoooooo");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}

