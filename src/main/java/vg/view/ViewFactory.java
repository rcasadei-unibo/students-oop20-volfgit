package vg.view;

import vg.controller.gameBoard.GameBoardController;
import vg.utils.GameState;

import java.util.Optional;

public class ViewFactory {

     private static AdaptableView<ViewController> makeAdaptableView(final String resName) {
        return new AdaptableView<>(resName);
    }

    public static View gameOverView() {
        return makeAdaptableView("/layout/GameOver.fxml");
     }

    /**
     * Load gameboard view and its view controller from file.
     * @return GameBoard {@link AdaptableView}.
     */
    public static AdaptableView<GameBoardController> newGameBoardView() {
        return new AdaptableView<>("/layout/GameBoard1.fxml");
    }

    public static View pauseView() {
        return makeAdaptableView("/layout/PauseView.fxml");
    }
}
