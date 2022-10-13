package vg.view.gameBoard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.view.utils.KeyEventHandler;
import vg.utils.LoadFxmlUtils;
import vg.view.ViewManager;

public class GameBoard extends Application {

    private static Stage stage;
    GameBoardController controller = new GameBoardController();
    ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        GameBoard.stage = stage;
        stage.setTitle("Volfgit");
        stage.addEventFilter(KeyEvent.ANY, new KeyEventHandler());
        Rectangle rect = new Rectangle(100, 100, 100, 100);
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        FXMLLoader.getDefaultClassLoader().ge
        this.stage.setScene(scene);
        stage.sizeToScene();
        scene.getRoot().lookup("#gameArea").setClip(rect);

        scene.getRoot().lookup("#gameArea").setStyle("-fx-background-color: #000000;");
        scene.getRoot().lookup("#gameAreaDue").setStyle("-fx-background-color: #2a77ff;");

        controller.stampa();

        stage.show();
    }
    public static Scene loadMainMenu() {
        return new Scene(LoadFxmlUtils.loadFxml("layout/mainMenu.fxml"));
    }
}

