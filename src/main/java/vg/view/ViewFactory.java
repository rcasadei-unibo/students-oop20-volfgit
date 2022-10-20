package vg.view;

import vg.controller.gameBoard.GameBoardController;
import vg.view.gameOver.GameOverView;
import vg.view.gameOver.GameOverViewController;
import vg.view.utils.CountdownView;

public class ViewFactory {

     private static <T> AdaptableView<T> makeAdaptableView(final String resName) {
        return new AdaptableView<T>(resName);
    }

    public static CountdownView<GameOverViewController> gameOverView() {
        return new GameOverView();
     }

    /**
     * Load gameboard view and its view controller from file.
     * @return GameBoard {@link AdaptableView}.
     */
    public static AdaptableView<GameBoardController> newGameBoardView() {
        return new AdaptableView<>("/layout/GameBoard1.fxml");
    }

    public static View<ViewController> pauseView() {
        return makeAdaptableView("/layout/PauseView.fxml");
    }
}
