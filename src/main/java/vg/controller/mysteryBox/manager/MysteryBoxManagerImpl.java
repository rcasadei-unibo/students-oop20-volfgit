package vg.controller.mysteryBox.manager;

import com.sun.javafx.geom.Vec2d;
import vg.controller.gameBoard.GameBoardController;
import vg.controller.mysteryBox.MysteryBoxController;
import vg.controller.mysteryBox.StaticFactoryMysteryBox;
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
        List<Vec2d> pos = MysteryBoxPositionUtils.POSITION_ROUND.get(this.round);

        MysteryBoxController mysteryBoxBoss = StaticFactoryMysteryBox.createWeaponForBoss();
        mysteryBoxBoss.setPosition(pos.get(0));
        this.mysteryBoxList.add(mysteryBoxBoss);
        gameBoard.addInGameArea(mysteryBoxBoss.getNode());


        pos.stream().skip(1).forEach(vec2d -> {
            MysteryBoxController mysteryBox = StaticFactoryMysteryBox.createRandomMysteryBox();
            mysteryBox.setPosition(vec2d);
            this.mysteryBoxList.add(mysteryBox);
            gameBoard.addInGameArea(mysteryBox.getNode());
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
