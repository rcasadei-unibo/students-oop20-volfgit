package vg.controller.mysteryBox.manager;

import javafx.scene.layout.Pane;
import vg.controller.gameBoard.GameBoardController;

public interface MysteryBoxManager {

    public void initializeRound(GameBoardController gameBoard);

    public int getRound();

    public void increaseRound();

}
