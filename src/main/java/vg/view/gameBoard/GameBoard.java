package vg.view.gameBoard;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import vg.controller.GameController;
import vg.model.MapImpl;
import vg.model.StageImpl;
import vg.utils.LoadFxmlUtils;
import vg.utils.V2D;
import vg.view.AdaptableView;
import vg.view.View;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.view.utils.KeyEventHandler;

import java.awt.Button;
import java.io.File;

public class GameBoard extends Application {

    ViewManager viewManager;

    @Override
    public void start(final Stage stage) throws Exception {

        AdaptableView gameView = new GameBoardView();
        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());
        GameController gameController = new GameController(gameView, viewManager);

        gameView.setController(gameController);
        viewManager.addScene(gameView);

        stage.setTitle("GameBoard");

        stage.setMinWidth(950);
        stage.setMinHeight(490);
        stage.setMaxWidth(1400);
        stage.setMaxHeight(950);
//        stage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//        stage.minHeightProperty().bind(scene.widthProperty().divide(2));

        //Stop game thread when window app is closing
        stage.setOnCloseRequest(event -> {
            gameController.closeGame();
        });

        stage.show();
        gameController.gameLoop();
    }
}

