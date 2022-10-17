package vg.controller.mysteryBox.manager;

import com.sun.javafx.geom.Vec2d;
import vg.controller.mysteryBox.MysteryBoxController;
import vg.utils.Round.MysteryBoxPositionUtils;

import java.util.ArrayList;
import java.util.List;

public class MysteryBoxManagerImpl implements MysteryBoxManager {

    private final List<MysteryBoxController> mysteryBoxList;
    private int round;

    public MysteryBoxManagerImpl() {
        this.mysteryBoxList = new ArrayList<>();
        this.round = 0;
    }


    @Override
    public void initializeRound() {
        List<Vec2d> pos = MysteryBoxPositionUtils.POSITION_ROUND.get(round);

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
