package vg.view.gameBoard;

import javafx.application.Application;
import javafx.stage.Stage;
import vg.controller.GameControllerImpl;
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
        vg.model.Stage<V2D> stageModel = null;
        try {
            stageModel = new StageImpl<>();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1) CREATE view
        AdaptableView<GameBoardController> gameView = ViewFactory.newGameBoardView();
        // 2) CREATE createMysteryBox logic controller
        GameControllerImpl gameController = new GameControllerImpl(gameView, stageModel, viewManager);
        // 3) set logic controller in view
        gameView.setIoLogicController(gameController);
        //4) if you want to see add it to the viewManager
        viewManager.addScene(gameView);


        stage.setOnCloseRequest(event -> {
            gameController.closeGame();
            System.exit(0);
        });



/*
        LeaderBoardView leaderBoardView = new LeaderBoardView();
        LeaderBoardController leaderBoardController = new LeaderBoardController(leaderBoardView, viewManager);
        leaderBoardView.setIoLogicController(leaderBoardController);

        viewManager.addScene(leaderBoardView);
*/
        stage.setTitle("GameBoard");
        stage.setResizable(false);
        stage.show();

        //Deve stare qui perchè prima dello show i dati dei pane non sono caricati dalle dimensioni
        gameController.launchGameSession();
    }
}
