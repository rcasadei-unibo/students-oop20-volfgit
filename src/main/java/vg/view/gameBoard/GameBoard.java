package vg.view.gameBoard;

import javafx.application.Application;
import javafx.stage.Stage;
import vg.controller.GameController;
import vg.controller.gameBoard.GameBoardController;
import vg.controller.mysteryBox.manager.MysteryBoxManager;
import vg.controller.mysteryBox.manager.MysteryBoxManagerImpl;
import vg.controller.player.PlayerController;
import vg.controller.player.PlayerControllerImpl;
import vg.view.AdaptableView;
import vg.view.ViewFactory;
import vg.view.ViewManager;
import vg.view.ViewManagerImpl;
import vg.view.utils.KeyEventHandler;

public class GameBoard extends Application {

    /**
     * View Manager.
     * {@see ViewManager}
     */
    private ViewManager viewManager;

    @Override
    public void start(final Stage stage) {
        viewManager = new ViewManagerImpl(stage, new KeyEventHandler());

        MysteryBoxManager mysteryBoxManager = new MysteryBoxManagerImpl();

        // 1) CREATE view
        AdaptableView<GameBoardController> gameView = ViewFactory.newGameBoardView();
        // 2) CREATE create logic controller
        GameController gameController = new GameController(gameView, viewManager);
        PlayerController playerController = new PlayerControllerImpl();
        playerController.setPlayerInGameArea(gameView.getViewController());
        // 3) set logic controller in view
        gameView.setIoLogicController(gameController);

        //4) if you wanna see add it to the viewManager
        viewManager.addScene(gameView);
        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.show();

        mysteryBoxManager.initializeRound(gameView.getViewController());

        stage.setOnCloseRequest(event -> gameController.closeGame());
        gameController.gameLoop();

    }
}

