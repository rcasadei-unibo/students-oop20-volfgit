package vg.controller.entity.mystery_box;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.factory.StaticFactoryAbilityDurable;
import vg.model.mystery_box.factory.StaticFactoryAbilityInstant;
import vg.utils.path.PathImageMysteryBox;
import vg.view.entity.StaticFactoryEntityBlock;

public class StaticFactoryMysteryBox {

    private static MysteryBoxController createRandom(final EAbility eAbility) {
        switch (eAbility) {
            case FREEZE_TIME:
                return createFreezeTime();
            case KILL_ALL_MOSQUITOES:
                return createKillMosquitoes();
            case SCORE:
                return createScore();
            case SPEED_UP:
                return createSpeed();
            case WEAPON_MOSQUITOES:
                return createWeaponForMosquitoes();
            case WEAPON_BOSS:
                return createWeaponForBoss();
            default:
                throw new IllegalArgumentException("Unknown ability: " + eAbility);
        }
    }

    public static MysteryBoxController createRandomMysteryBoxDefault() {
        return createRandom(EAbility.randomAllButBoss());
    }

    public static MysteryBoxController createRandomMysteryBoxWithWeaponBoss() {
        MysteryBoxController mysteryBoxController = createRandom(EAbility.randomAll());
        mysteryBoxController.setImage(PathImageMysteryBox.MYSTERY_BOSS);
        return mysteryBoxController;
    }

    public static MysteryBoxController createFreezeTime() {
        var model = StaticFactoryAbilityDurable.createFreezeTime();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createKillMosquitoes() {
        var model = StaticFactoryAbilityInstant.createKillMosquitoes();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createScore() {
        var model = StaticFactoryAbilityInstant.createScore();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createSpeed() {
        var model = StaticFactoryAbilityDurable.createSpeedUp();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createWeaponForMosquitoes() {
        var model = StaticFactoryAbilityDurable.createWeaponForMosquitoes();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createWeaponForBoss() {
        var model = StaticFactoryAbilityDurable.createWeaponForBoss();
        var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }




}
