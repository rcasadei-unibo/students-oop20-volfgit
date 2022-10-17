package vg.view.gameBoard;

import javafx.scene.Scene;
import vg.utils.GameState;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

public class GameViewFactory {

    static private AdaptableView makeAdaptableView(final String relativePath) {
        Scene scene = new Scene(LoadFxmlUtils.loadFxml(relativePath));
        return new AdaptableView(scene) {
            @Override
            public void draw() {
            }

            @Override
            public void reset() {
            }
        };
    }

    static public AdaptableView viewState(final GameState gameState) {
        if (gameState == GameState.PAUSED) {
            return makeAdaptableView("layout/PauseView.fxml");
        } else if (gameState == GameState.GAMEOVER) {
            return makeAdaptableView("layout/GameOver.fxml");
        } else return null;
    }
}
