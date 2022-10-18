package vg.view;

import vg.controller.gameBoard.GameBoardController;
import vg.utils.GameState;
import vg.view.utils.NoViewController;

public class ViewFactory {

     private static AdaptableView<NoViewController> makeAdaptableView(final String resName) {
        return new AdaptableView<>(resName);
    }

     public static AdaptableView<NoViewController> viewState(final GameState gameState) {
        if (gameState == GameState.PAUSED) {
            return makeAdaptableView("/layout/PauseView.fxml");
        } else if (gameState == GameState.GAMEOVER) {
            return makeAdaptableView("/layout/GameOver.fxml");
        } else return null;
     }

    /**
     * Load gameboard view and its view controller from file.
     * @return GameBoard {@link AdaptableView}.
     */
    public static AdaptableView<GameBoardController> newGameBoardView() {
        return new AdaptableView<>("/layout/GameBoard1.fxml");
    }


}
