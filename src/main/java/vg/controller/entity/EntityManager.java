package vg.controller.entity;

import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.utils.V2D;

import java.util.List;

public interface EntityManager {
    void initializeRound(GameBoardController gameController);

    List<MysteryBoxController> getMysteryBoxList();

    void updateBlinkingMysteryBox(long elapsedTime);

    void checkMysteryBoxOnBorder(Stage<V2D> stage);
}