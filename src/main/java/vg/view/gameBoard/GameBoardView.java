package vg.view.gameBoard;

import javafx.scene.Scene;
import vg.utils.DimensionUtils;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

public class GameBoardView extends AdaptableView {

    protected GameBoardView() {
        super(new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard1.fxml"),
                DimensionUtils.DEFAULT_WIDTH,
                DimensionUtils.DEFAULT_HEIGHT));
    }
}
