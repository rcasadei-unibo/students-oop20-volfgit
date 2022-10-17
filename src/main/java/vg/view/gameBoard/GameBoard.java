package vg.view.gameBoard;

import javafx.application.Application;

import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import vg.controller.GameController;
import vg.controller.gameBoard.GameBoardControllerImpl;
import vg.utils.DimensionUtils;
import vg.view.AdaptableView;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.view.block.ManagerBlock;
import vg.view.utils.KeyEventHandler;

import java.io.IOException;

public class GameBoard extends Application {

    private static Stage stage;
    GameBoardControllerImpl controller;

    ManagerBlock managerBlock = new ManagerBlock();
    ViewManager viewManager;

    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader load = new FXMLLoader(getClass().getResource("/layout/GameBoard1.fxml"));
        Parent root = load.load();
        this.controller = load.getController();
        Scene scene = new Scene(root, DimensionUtils.DEFAULT_WIDTH, DimensionUtils.DEFAULT_HEIGHT);

        AdaptableView gameView = new GameBoardView(scene);
        GameController gameController = new GameController(gameView, viewManager);
        gameView.setController(gameController);

        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());
        viewManager.addScene(gameView);

        managerBlock.createBlock(this.controller.getGameArea());

        stage.setOnCloseRequest(event -> {
            gameController.closeGame( );
            System.out.println("close");
            System.exit(0);
        });

        stage.show();
    }
}

