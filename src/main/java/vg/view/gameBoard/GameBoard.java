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
import vg.utils.LoaderFXMLUtils;
import vg.view.AdaptableView;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.view.utils.KeyEventHandler;

import java.io.IOException;

public class GameBoard extends Application {

    private static Stage stage;
    private GameBoardControllerImpl controller;
    private MysteryBoxManager mysteryBoxManager;

    ViewManager viewManager;

    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader load = LoaderFXMLUtils.GetLoader("/layout/GameBoard1.fxml");
        Parent root = load.load();
        this.controller = load.getController();
        Scene scene = new Scene(root, DimensionUtils.DEFAULT_WIDTH, DimensionUtils.DEFAULT_HEIGHT);

        this.mysteryBoxManager = new MysteryBoxManagerImpl();


        AdaptableView gameView = new GameBoardView(scene);
        GameController gameController = new GameController(gameView, viewManager);
        gameView.setController(gameController);

        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        this.mysteryBoxManager.initializeRound(this.controller);


        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());
        viewManager.addScene(gameView);


        stage.setOnCloseRequest(event -> gameController.closeGame());

        gameController.gameLoop();

    }
}

