package vg.controller.mystery_box;

import vg.model.mysteryBox.ability.AbilityFreezeTime;
import vg.model.mysteryBox.ability.AbilityKillMosquitoes;
import vg.model.mysteryBox.ability.AbilityScore;
import vg.model.mysteryBox.ability.AbilitySpeed;
import vg.model.mysteryBox.ability.AbilityWeapon;
import vg.model.mysteryBox.factory.StaticFactoryFreezeTimeAbility;
import vg.model.mysteryBox.factory.StaticFactoryMosquitoesAbility;
import vg.model.mysteryBox.factory.StaticFactoryScoreAbility;
import vg.model.mysteryBox.factory.StaticFactorySpeedAbility;
import vg.model.mysteryBox.factory.StaticFactoryWeaponAbility;
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
            case 5:
                return createWeaponForBoss();
        }
        return null;
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
