package vg.controller.entity.mystery_box.manager;

import vg.controller.gameBoard.GameBoardController;
import vg.model.entity.dynamicEntity.player.Player;

public interface MysteryBoxManager {

    public void initializeRound(GameBoardController gameBoard);

    public int getRound();

    public void increaseRound();

    public void updateBlinkingMysteryBox(long elapsedTime);

    public void checkCollision(Player player);
}
