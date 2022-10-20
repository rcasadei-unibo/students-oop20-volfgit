package vg.controller.mystery_box.manager;

import vg.controller.gameBoard.GameBoardController;

public interface MysteryBoxManager {

    public void initializeRound(GameBoardController gameBoard);

    public int getRound();

    public void increaseRound();

}
