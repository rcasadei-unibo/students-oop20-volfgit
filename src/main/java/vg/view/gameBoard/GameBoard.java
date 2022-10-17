package vg.view.gameBoard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vg.controller.GameController;
import vg.controller.gameBoard.GameBoardControllerImpl;
import vg.controller.mysteryBox.manager.MysteryBoxManager;
import vg.controller.mysteryBox.manager.MysteryBoxManagerImpl;
import vg.utils.DimensionUtils;
import vg.view.AdaptableView;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.view.utils.KeyEventHandler;

import java.io.IOException;

public class GameBoard extends Application {

    private GameBoardControllerImpl controller;
    private MysteryBoxManager mysteryBoxManager;

    ViewManager viewManager;

    @Override
    public void start(final Stage stage) {

        AdaptableView gameView = new GameBoardView();
        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());
        //this.controller = load.getController();
        //Scene scene = new Scene(root, DimensionUtils.DEFAULT_WIDTH, DimensionUtils.DEFAULT_HEIGHT);
        this.mysteryBoxManager = new MysteryBoxManagerImpl();

        GameController gameController = new GameController(gameView, viewManager);
        gameView.setController(gameController);
        //add first view to viewStack then set scene to the stage
        viewManager.addScene(gameView);

        stage.setTitle("GameBoard");

        stage.setMinWidth(950);
        stage.setMinHeight(490);
        stage.setMaxWidth(1400);
        stage.setMaxHeight(950);
//        stage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//        stage.minHeightProperty().bind(scene.widthProperty().divide(2));

        stage.setResizable(false);
        stage.show();

        this.mysteryBoxManager.initializeRound(this.controller);

        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());
        viewManager.addScene(gameView);

        stage.setOnCloseRequest(event -> gameController.closeGame());
        gameController.gameLoop();

    }
}

