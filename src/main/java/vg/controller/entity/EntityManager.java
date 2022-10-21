package vg.controller.entity;

import vg.controller.gameBoard.GameBoardController;
import vg.model.entity.dynamicEntity.player.Player;

public interface EntityManager {
    public void initializeRound(GameBoardController gameController);

    public void updateBlinkingMysteryBox(long elapsedTime);

    public  void checkCollision(Player player);
}
