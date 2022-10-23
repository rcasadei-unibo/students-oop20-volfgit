package vg.controller.entity;

import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.manager.MysteryBoxManager;
import vg.controller.entity.mystery_box.manager.MysteryBoxManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.V2D;

import java.util.List;

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
    public List<MysteryBoxController> getMysteryBoxList() {
        return this.mysteryBoxManager.getMysteryBoxList();
    }

    @Override
    public void updateBlinkingMysteryBox(long elapsedTime) {
        this.mysteryBoxManager.updateBlinkingMysteryBox(elapsedTime);
    }

    @Override
    public void checkCollision(Stage<V2D> stage) {
        this.mysteryBoxManager.checkCollision(stage);
    }
}
