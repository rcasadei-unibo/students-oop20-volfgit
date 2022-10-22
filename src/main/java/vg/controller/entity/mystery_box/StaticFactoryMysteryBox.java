package vg.controller.entity.mystery_box;

import vg.model.mystery_box.ability.AbilityFreezeTime;
import vg.model.mystery_box.ability.AbilityKillMosquitoes;
import vg.model.mystery_box.ability.AbilityScore;
import vg.model.mystery_box.ability.AbilitySpeed;
import vg.model.mystery_box.ability.AbilityWeapon;
import vg.model.mystery_box.factory.StaticFactoryFreezeTimeAbility;
import vg.model.mystery_box.factory.StaticFactoryMosquitoesAbility;
import vg.model.mystery_box.factory.StaticFactoryScoreAbility;
import vg.model.mystery_box.factory.StaticFactorySpeedAbility;
import vg.model.mystery_box.factory.StaticFactoryWeaponAbility;
import vg.utils.path.PathImageMysteryBox;
import vg.view.entity.StaticFactoryEntityBlock;

import java.util.Random;

public class StaticFactoryMysteryBox {

    public static MysteryBoxController createRandomMysteryBox() {
        int rnd = new Random().nextInt(5);
        switch (rnd) {
            case 0:
                return createFreezeTime();
            case 1:
                return createKillMosquitoes();
            case 2:
                return createScore();
            case 3:
                return createSpeed();
            case 4:
                return createWeaponForMosquitoes();
        }
        return null;
    }

    public static MysteryBoxController createRandomMysteryBoxWithWeaponBoss() {
        int rnd = new Random().nextInt(6);
        MysteryBoxController mysteryBoxController = null;
        switch (rnd) {
            case 0:
                mysteryBoxController = createFreezeTime();
            case 1:
                mysteryBoxController = createKillMosquitoes();
            case 2:
                mysteryBoxController = createScore();
            case 3:
                mysteryBoxController = createSpeed();
            case 4:
                mysteryBoxController = createWeaponForMosquitoes();
            case 5:
                mysteryBoxController = createWeaponForBoss();
        }
        mysteryBoxController.setImage(PathImageMysteryBox.MYSTERY_BOSS);
        return mysteryBoxController;
    }

    public static MysteryBoxController<AbilityFreezeTime> createFreezeTime() {
        var model = StaticFactoryFreezeTimeAbility.createSmallTime();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }

    public static MysteryBoxController<AbilityKillMosquitoes> createKillMosquitoes() {
        var model = StaticFactoryMosquitoesAbility.createKillMosquitoes();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }

    public static MysteryBoxController<AbilityScore> createScore() {
        var model = StaticFactoryScoreAbility.createScoreMedium();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }

    public static MysteryBoxController<AbilitySpeed> createSpeed() {
        var model = StaticFactorySpeedAbility.createMediumSpeed();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }

    public static MysteryBoxController<AbilityWeapon> createWeaponForMosquitoes() {
        var model = StaticFactoryWeaponAbility.createWeaponForMosquitoes();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }

    public static MysteryBoxController<AbilityWeapon> createWeaponForBoss() {
        var model = StaticFactoryWeaponAbility.createWeaponForBoss();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl<>(model, view);
    }




}
