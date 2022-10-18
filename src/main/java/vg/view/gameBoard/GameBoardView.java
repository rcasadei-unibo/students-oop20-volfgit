package vg.view.gameBoard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import vg.controller.gameBoard.GameBoardController;
import vg.utils.DimensionUtils;
import vg.view.AdaptableView;
import vg.view.menu.confirmMenu.ConfirmView;
import java.io.IOException;

public class GameBoardView extends AdaptableView<GameBoardController> {

    private GameBoardView(final Scene scene, final GameBoardController viewController) {
        super(scene, viewController);
    }

    /**
     * Load confirmation view and its view controller from file.
     * @return new confirmation dialog screen.
     */
    public static GameBoardView newGameBoardView() {
        FXMLLoader loader = new FXMLLoader(ConfirmView.class.getResource("/layout/GameBoard1.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(),
                    DimensionUtils.DEFAULT_WIDTH,
                    DimensionUtils.DEFAULT_HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameBoardController viewController = loader.getController();
        return new GameBoardView(scene, viewController);
    }
}
