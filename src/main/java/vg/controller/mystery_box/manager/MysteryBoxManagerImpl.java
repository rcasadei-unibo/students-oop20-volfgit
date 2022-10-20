package vg.controller.mystery_box.manager;

import vg.controller.gameBoard.GameBoardController;
import vg.controller.mystery_box.MysteryBoxController;
import vg.controller.mystery_box.StaticFactoryMysteryBox;
import vg.utils.Round.MysteryBoxPositionUtils;
import vg.utils.V2D;

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
        List<V2D> pos = MysteryBoxPositionUtils.POSITION_ROUND.get(this.round);

        MysteryBoxController mysteryBoxBoss = StaticFactoryMysteryBox.createRandomMysteryBoxWithWeaponBoss();
        mysteryBoxBoss.setPosition(pos.get(0));
        this.mysteryBoxList.add(mysteryBoxBoss);
        mysteryBoxBoss.setInParentNode(gameBoard.getGameAreaNode());


        pos.stream().skip(1).forEach(vec2d -> {
            MysteryBoxController mysteryBox = StaticFactoryMysteryBox.createRandomMysteryBox();
            mysteryBox.setPosition(vec2d);
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
}
