package vg.view;

import vg.controller.GameOverController;
import vg.controller.gameBoard.GameBoardController;
import vg.controller.leaderboard.LeaderBoardController;
import vg.controller.menu.MenuController;
import vg.controller.prompt.PromptController;
import vg.controller.prompt.PromptObserver;
import vg.view.gameOver.GameOverView;
import vg.view.leaderBoard.LeaderBoardView;
import vg.view.menu.MenuView;
import vg.view.menu.prompt.PromptView;
import vg.view.transition.TransitionView;
import vg.view.transition.TransitionViewController;
import vg.view.utils.CountdownView;

public class ViewFactory {

     private static <T> AdaptableView<T> makeAdaptableView(final String resName) {
        return new AdaptableView<T>(resName);
    }

    public static GameOverView gameOverView(final int score, final int round, final ViewManager viewManager) {
        GameOverView gameOverView = new GameOverView();
        GameOverController gameOverController = new GameOverController(gameOverView, viewManager);
        gameOverView.setIoLogicController(gameOverController);
        gameOverController.set(score, round);
        return gameOverView;
     }

    /**
     * Load gameboard view and its view controller from file.
     * @return GameBoard {@link AdaptableView}.
     */
    public static AdaptableView<GameBoardController> newGameBoardView() {
        return new AdaptableView<>("/layout/GameBoard1.fxml");
    }

    /**
     * Return pause view.
     * @return
     */
    public static View<ViewController> pauseView() {
        return makeAdaptableView("/layout/PauseView.fxml");
    }

    public static CountdownView<TransitionViewController> transitionView(final int score, final int round) {
        CountdownView<TransitionViewController> transitionView =  new TransitionView();
        transitionView.getViewController().setLevel(round);
        transitionView.getViewController().setScore(score);
        return transitionView;
    }

    public static LeaderBoardView leaderBoardView(final ViewManager viewManager) {
        LeaderBoardView leaderBoardView = new LeaderBoardView();
        LeaderBoardController leaderBoardController = new LeaderBoardController(leaderBoardView, viewManager);
        leaderBoardView.setIoLogicController(leaderBoardController);
        return leaderBoardView;
    }

      public static PromptView promptView(final ViewManager viewManager, final PromptObserver observer) {
        PromptView promptView = PromptView.newConfirmDialogView();
        PromptController promptController =
                new PromptController(promptView, viewManager, observer);
        promptView.setIoLogicController(promptController);
        return  promptView;
    }

    public static MenuView menuView(final ViewManager viewManager) {
        MenuView menuView = new MenuView();
        MenuController menuController = new MenuController(menuView, viewManager);
        menuView.setIoLogicController(menuController);
        return menuView;
    }
}
