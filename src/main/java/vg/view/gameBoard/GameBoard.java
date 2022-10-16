package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import vg.utils.LoadFxmlUtils;
import vg.view.ViewManager;

import java.awt.Button;
import java.io.File;

public class GameBoard extends Application {

    private static Stage stage;
    GameBoardController controller = new GameBoardController();
    ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        stage.setTitle("GameBoard");
        stage.setScene(scene);

        stage.setMinWidth(1400);
        stage.setMinHeight(950);
        stage.setMaxWidth(1400);
        stage.setMaxHeight(950);
//        stage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//        stage.minHeightProperty().bind(scene.widthProperty().divide(2));

        stage.show();
    }
}

