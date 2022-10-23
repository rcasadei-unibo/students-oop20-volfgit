package vg.controller.entity.mystery_box.manager;

import vg.controller.entity.mystery_box.MysteryBoxController;
import vg.controller.entity.mystery_box.StaticFactoryMysteryBox;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.model.mystery_box.AbilityDurable;
import vg.model.mystery_box.ETypeAbility;
import vg.model.mystery_box.data_round.DataRound;
import vg.utils.Round.MysteryBoxPositionUtils;
import vg.utils.V2D;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            MysteryBoxController mysteryBox = StaticFactoryMysteryBox.createRandomMysteryBoxDefault();
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
    public List<MysteryBoxController> getMysteryBoxList() {
        return this.mysteryBoxList;
    }

    @Override
    public List<MysteryBoxController> getMysteryBoxActiveAndDurableList() {
        return this.mysteryBoxList.stream()
                .filter(mysteryBox -> mysteryBox.isType(ETypeAbility.DURABLE) && mysteryBox.isActivated())
                .collect(Collectors.toList());
    }

    @Override
    public void increaseRound() {
        this.round++;
    }

    @Override
    public void updateTimeBlinking(final long elapsedTime) {
        this.mysteryBoxList.forEach(mysteryBox -> mysteryBox.updateBlinking(elapsedTime));
    }
    @Override
    public void updateTimeIfAbilityActive(final long elapsedTime, final Stage<V2D> stage) {
        List<MysteryBoxController> mysteryBoxActivateList = this.getMysteryBoxActiveAndDurableList();

        mysteryBoxActivateList.forEach(mysteryBox -> {
            AbilityDurable abilityDurable = mysteryBox.getDurability();
            abilityDurable.updateTimer(elapsedTime);
            if (abilityDurable.isTimeOver()) {
                abilityDurable.deActivate(stage);
            }
        });

    }

    @Override
    public void checkMysteryBoxOnBorder(final Stage<V2D> stage, final GameBoardController gameController) {
        this.mysteryBoxList.forEach(mysteryBox -> mysteryBox.checkOnBorder(stage, gameController));
    }



}
