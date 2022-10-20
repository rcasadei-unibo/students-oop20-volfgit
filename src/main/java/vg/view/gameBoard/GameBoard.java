package vg.view.gameBoard;

import javafx.application.Application;
import javafx.stage.Stage;
import vg.controller.GameController;
import vg.controller.entity.EntityManager;
import vg.controller.entity.EntityManagerImpl;
import vg.controller.gameBoard.GameBoardController;
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

        // 1) CREATE view
        AdaptableView<GameBoardController> gameView = ViewFactory.newGameBoardView();
        // 2) CREATE createMysteryBox logic controller
        GameController gameController = new GameController(gameView, viewManager);
        // 3) set logic controller in view
        gameView.setIoLogicController(gameController);

        //4) if you want to see add it to the viewManager
        viewManager.addScene(gameView);
/*
        LeaderBoardView leaderBoardView = new LeaderBoardView();
        LeaderBoardController leaderBoardController = new LeaderBoardController(leaderBoardView, viewManager);
        leaderBoardView.setIoLogicController(leaderBoardController);

        viewManager.addScene(leaderBoardView);
*/
        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.show();


        stage.setOnCloseRequest(event -> {
            gameController.closeGame();
            System.exit(0);
        });
        gameController.gameLoop();
    }
}
