package vg.view.gameBoard;

import javafx.application.Application;
import javafx.stage.Stage;
<<<<<<< HEAD
import vg.controller.GameControllerImpl;
=======
import vg.controller.GameController;
>>>>>>> d376d4e940b468ed93af3ee1bca6f2a51105dddc
import vg.controller.gameBoard.GameBoardController;
import vg.model.StageImpl;
import vg.utils.V2D;
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

        try {
            vg.model.Stage<V2D> stageModel = new StageImpl<>();

            // 1) CREATE view
            AdaptableView<GameBoardController> gameView = ViewFactory.newGameBoardView();
            // 2) CREATE createMysteryBox logic controller
            GameControllerImpl gameController = new GameControllerImpl(gameView, stageModel, viewManager);
            // 3) set logic controller in view
            gameView.setIoLogicController(gameController);
            //4) if you want to see add it to the viewManager
            viewManager.addScene(gameView);
            gameController.launchGameSession();

            stage.setOnCloseRequest(event -> {
                gameController.closeGame();
                System.exit(0);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        LeaderBoardView leaderBoardView = new LeaderBoardView();
        LeaderBoardController leaderBoardController = new LeaderBoardController(leaderBoardView, viewManager);
        leaderBoardView.setIoLogicController(leaderBoardController);

        viewManager.addScene(leaderBoardView);
*/
        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.show();

    }
}
