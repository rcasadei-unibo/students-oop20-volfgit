package vg.controller.entity.mystery_box.manager;

import vg.controller.gameBoard.GameBoardController;
import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.StaticFactoryMysteryBox;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mystery_box.data_round.DataRound;
import vg.utils.Round.MysteryBoxPositionUtils;

import java.util.ArrayList;
import java.util.List;

public class MysteryBoxManagerImpl implements MysteryBoxManager {

    private final List<MysteryBoxController> mysteryBoxList;
    private int round;

    public MysteryBoxManagerImpl() {
        this.mysteryBoxList = new ArrayList<>();
        this.round = 1;
    }


    @Override
    public void initializeRound(final GameBoardController gameBoard) {
        List<DataRound> dataRoundList = MysteryBoxPositionUtils.getDataRoundList(this.round, gameBoard.getGameAreaDimension());

        MysteryBoxController mysteryBoxBoss = StaticFactoryMysteryBox.createRandomMysteryBoxWithWeaponBoss();
        mysteryBoxBoss.setDataRound(dataRoundList.get(0));
        this.mysteryBoxList.add(mysteryBoxBoss);
        mysteryBoxBoss.setInParentNode(gameBoard.getGameAreaNode());


        dataRoundList.stream().skip(1).forEach(dataRound -> {
            MysteryBoxController mysteryBox = StaticFactoryMysteryBox.createRandomMysteryBox();
            mysteryBox.setDataRound(dataRound);
            this.mysteryBoxList.add(mysteryBox);
            mysteryBox.setInParentNode(gameBoard.getGameAreaNode());
        });
    }

    @Override
    public int getRound() {
        return this.round;
    }

    @Override
    public void increaseRound() {
        this.round++;
    }

    @Override
    public void updateBlinkingMysteryBox(final long elapsedTime) {
        this.mysteryBoxList.forEach(mysteryBox -> mysteryBox.updateBlinking(elapsedTime));
    }

    @Override
    public void checkCollision(final Player player) {
        this.mysteryBoxList.forEach(mysteryBox -> mysteryBox.checkCollision(player));
    }
}
