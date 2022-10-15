package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.utils.LoadFxmlUtils;
import vg.view.ViewManager;

import java.io.File;

public class GameBoard extends Application {

    private static Stage stage;
    GameBoardController controller = new GameBoardController();
    ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("GameBoard");
       // Rectangle rect = new Rectangle(100, 0, 100, 100);
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));

        stage.setScene(scene);
        stage.setWidth(1160);
        stage.setHeight(740);




      //  scene.getRoot().lookup("#gameArea").setClip(rect);

      //  controller.stampa();
//        this.controller.initResize();

        stage.show();

    }
}

