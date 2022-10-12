package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.utils.LoadFxmlUtils;

public class GameBoard extends Application {

    GameBoardController controller = new GameBoardController();
    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rect = new Rectangle(100, 100, 100, 100);
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));

        stage.setScene(scene);
        stage.sizeToScene();

        scene.getRoot().lookup("#gameArea").setClip(rect);
        scene.getRoot().lookup("#gameArea").setStyle("-fx-background-color: #000000;");
        scene.getRoot().lookup("#gameAreaDue").setStyle("-fx-background-color: #2a77ff;");

        controller.stampa();

        stage.show();
    }
}

