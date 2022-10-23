package vg.controller.entity.mystery_box.manager;

import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.utils.V2D;

import java.util.List;

public interface MysteryBoxManager {
    void initializeRound(GameBoardController gameBoard);

    int getRound();

    List<MysteryBoxController> getMysteryBoxList();


    void increaseRound();

    void updateBlinkingMysteryBox(long elapsedTime);

    void checkMysteryBoxOnBorder(Stage<V2D> player, GameBoardController gameController);

}
