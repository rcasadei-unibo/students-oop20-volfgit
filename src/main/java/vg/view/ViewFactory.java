package vg.view;

import vg.controller.gameBoard.GameBoardController;
import vg.utils.GameState;

import java.util.Optional;

public class ViewFactory {

     private static AdaptableView<ViewController> makeAdaptableView(final String resName) {
        return new AdaptableView<>(resName);
    }

    public static Optional<View> viewState(final GameState gameState) {
        AdaptableView<ViewController> adaptableView = null;
        if (gameState == GameState.PAUSED) {
            adaptableView = makeAdaptableView("/layout/PauseView.fxml");
        } else if (gameState == GameState.GAMEOVER) {
            adaptableView = makeAdaptableView("/layout/GameOver.fxml");
        }
        return Optional.ofNullable(adaptableView);
     }

    /**
     * Load gameboard view and its view controller from file.
     * @return GameBoard {@link AdaptableView}.
     */
    public static AdaptableView<GameBoardController> newGameBoardView() {
        return new AdaptableView<>("/layout/GameBoard1.fxml");
    }


}
