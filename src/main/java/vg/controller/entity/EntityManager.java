package vg.controller.entity;

import vg.controller.gameBoard.GameBoardController;

public interface EntityManager {
    public void initializeRound(GameBoardController gameController);

    public void updateBlinkingMysteryBox(long elapsedTime);
}
