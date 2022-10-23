package vg.controller.entity;

import vg.controller.entity.boss.BossController;
import vg.controller.entity.boss.StaticFactoryBossController;
import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.manager.MysteryBoxManager;
import vg.controller.entity.mystery_box.manager.MysteryBoxManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.utils.V2D;

import java.util.List;

public class EntityManagerImpl implements EntityManager {
    private final MysteryBoxManager mysteryBoxManager;
    private final BossController boss;

    public EntityManagerImpl() {
        this.mysteryBoxManager = new MysteryBoxManagerImpl();
        this.boss = StaticFactoryBossController.createRound1();
    }

    @Override
    public void initializeRound(final GameBoardController gameController) {
        this.mysteryBoxManager.initializeRound(gameController);
        this.boss.setInParentNode(gameController);
    }

    @Override
    public List<MysteryBoxController> getMysteryBoxList() {
        return this.mysteryBoxManager.getMysteryBoxList();
    }

    @Override
    public void countingTimeMysteryBox(final long elapsedTime, final Stage<V2D> stage) {
        this.mysteryBoxManager.updateTimeBlinking(elapsedTime);
        this.mysteryBoxManager.updateTimeIfAbilityActive(elapsedTime, stage);
    }

    @Override
    public void checkMysteryBoxOnBorder(final Stage<V2D> stage, final GameBoardController gameController) {
        this.mysteryBoxManager.checkMysteryBoxOnBorder(stage, gameController);
    }
}
