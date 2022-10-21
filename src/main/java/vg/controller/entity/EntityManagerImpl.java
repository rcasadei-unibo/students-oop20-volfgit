package vg.controller.entity;

import vg.controller.entity.mystery_box.manager.MysteryBoxManager;
import vg.controller.entity.mystery_box.manager.MysteryBoxManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.model.entity.dynamicEntity.player.Player;

public class EntityManagerImpl implements EntityManager {
    private final MysteryBoxManager mysteryBoxManager;

    public EntityManagerImpl() {
        this.mysteryBoxManager = new MysteryBoxManagerImpl();
    }

    @Override
    public void initializeRound(GameBoardController gameController) {
        this.mysteryBoxManager.initializeRound(gameController);

    }

    @Override
    public void updateBlinkingMysteryBox(long elapsedTime) {
        this.mysteryBoxManager.updateBlinkingMysteryBox(elapsedTime);
    }

    @Override
    public void checkCollision(Player player) {
        this.mysteryBoxManager.checkCollision(player);
    }
}
