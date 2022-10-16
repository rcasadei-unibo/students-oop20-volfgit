package vg.view.gameBoard;

import javafx.scene.Scene;
import vg.controller.GameController;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.V2D;
import vg.view.AdaptableView;

public class GameBoardView extends AdaptableView {

    protected GameBoardView(final Scene scene) {
        super(scene);
    }

    public void printPlayer(final Player player) {
        System.out.println(player.getPosition().toString());
    }

    @Override
    public void draw() {

    }

    @Override
    public void reset() {

    }
}
