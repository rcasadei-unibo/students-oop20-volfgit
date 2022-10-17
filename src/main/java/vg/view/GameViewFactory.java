package vg.view;

import javafx.scene.Scene;
import vg.utils.DimensionUtils;
import vg.utils.GameState;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

import java.security.PublicKey;

public class GameViewFactory {

     private static AdaptableView makeAdaptableView(final String relativePath) {
        Scene scene = new Scene(LoadFxmlUtils.loadFxml(relativePath),
                DimensionUtils.DEFAULT_WIDTH,
                DimensionUtils.DEFAULT_HEIGHT);
        return new AdaptableView(scene) {
        };
    }

     public static AdaptableView viewState(final GameState gameState) {
        if (gameState == GameState.PAUSED) {
            return makeAdaptableView("layout/PauseView.fxml");
        } else if (gameState == GameState.GAMEOVER) {
            return makeAdaptableView("layout/GameOver.fxml");
        } else return null;
    }
}
