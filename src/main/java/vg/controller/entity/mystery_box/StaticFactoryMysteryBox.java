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
                return createFreezeTime();//createFreezeTime();
            case KILL_ALL_MOSQUITOES:
                return createFreezeTime();
            case SCORE:
                return createFreezeTime();
            case SPEED_UP:
                return createFreezeTime(); //createSpeed(); //createSpeed();//createWeaponForBoss();
            default:
                throw new IllegalArgumentException("Unknown ability: " + eAbility);
        }
    }

    public static MysteryBoxController createRandomMysteryBoxDefault() {
        return createRandom(EAbility.randomAllButBoss());
    }

    public static MysteryBoxController createRandomMysteryBoxWithWeaponBoss() {
        final MysteryBoxController mysteryBoxController = createRandom(EAbility.randomAll());
        mysteryBoxController.setImage(PathImageMysteryBox.MYSTERY_BOSS);
        return mysteryBoxController;
    }

    public static MysteryBoxController createFreezeTime() {
        final var model = StaticFactoryAbilityDurable.createFreezeTime();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createKillMosquitoes() {
        final var model = StaticFactoryAbilityInstant.createKillMosquitoes();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createScore() {
        final var model = StaticFactoryAbilityInstant.createScore();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createSpeed() {
        final var model = StaticFactoryAbilityDurable.createSpeedUp();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }
}
