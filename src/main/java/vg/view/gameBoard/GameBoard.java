package vg.view.gameBoard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vg.controller.GameController;
import vg.controller.mysteryBox.StaticFactoryMysteryBox;
import vg.utils.DimensionUtils;
import vg.view.AdaptableView;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.controller.gameBoard.GameBoardControllerImpl;
import vg.view.utils.KeyEventHandler;

import java.io.IOException;

public class GameBoard extends Application {

    private static Stage stage;
    private GameBoardControllerImpl controller;

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

        var mysteryBoxFreezeTime = StaticFactoryMysteryBox.createFreezeTime();
        this.controller.addInGameArea(mysteryBoxFreezeTime.getNode());

//        managerBlock.createBlock(this.controller.getGameArea());



        stage.setOnCloseRequest(event -> {
            System.out.println("close");
            System.exit(0);
            // TODO teo metti la funzione per chiudere il gioco... il thread
        });

        gameController.gameLoop();

    }
}

