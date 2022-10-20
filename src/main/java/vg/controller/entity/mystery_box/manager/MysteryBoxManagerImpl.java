package vg.controller.entity.mystery_box.manager;

import vg.controller.gameBoard.GameBoardController;
import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.StaticFactoryMysteryBox;
import vg.model.mysteryBox.dataRound.DataRound;
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
    public void initializeRound(GameBoardController gameBoard) {
        List<DataRound> dataRoundList = MysteryBoxPositionUtils.POSITION_ROUND.get(this.round);

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
    public void updateBlinkingMysteryBox(long elapsedTime) {
        System.out.println("updateBlinkingMysteryBox " + elapsedTime);
    }
}
