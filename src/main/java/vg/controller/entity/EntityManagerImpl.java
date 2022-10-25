package vg.controller.entity;

import vg.controller.entity.boss.BossController;
import vg.controller.entity.boss.StaticFactoryBossController;
import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.manager.MysteryBoxManager;
import vg.controller.entity.mystery_box.manager.MysteryBoxManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.sound.manager.SoundManager;
import vg.utils.V2D;

import java.util.List;

public class EntityManagerImpl implements EntityManager {
    private final MysteryBoxManager mysteryBoxManager;
    private BossController boss;
    private SoundManager soundManager;

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
    public BossController getBoss() {
        return this.boss;
    }

    @Override
    public void countingTimeMysteryBox(final long elapsedTime, final Stage<V2D> stage) {
        this.mysteryBoxManager.updateTimeBlinking(elapsedTime);
        this.mysteryBoxManager.showPickUpMysteryBox(elapsedTime);
        this.mysteryBoxManager.updateTimeIfAbilityActive(elapsedTime, stage);
    }

    @Override
    public void checkMysteryBoxOnBorder(final Stage<V2D> stage, final GameBoardController gameController) {
        this.mysteryBoxManager.checkMysteryBoxOnBorder(stage, gameController, this.soundManager);
    }

    @Override
    public void moveEntityBoss(final long elapsedTime) {
        this.boss.move();
    }

    @Override
    public void setSoundManager(final SoundManager soundManager) {
        this.soundManager = soundManager;
    }

    @Override
    public void updateAnimation() {
        this.boss.updateAnimation();
        this.mysteryBoxManager.updateAnimation();
    }
}
