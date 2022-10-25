package vg.controller.entity.mystery_box;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.factory.AbstractFactoryMysteryBox;
import vg.model.mystery_box.factory.ConcreteFactoryEasyMysteryBox;
import vg.view.entity.StaticFactoryEntityBlock;

public final class StaticFactoryMysteryBox {
    private StaticFactoryMysteryBox() {
    }

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
            default:
                throw new IllegalArgumentException("Unknown ability: " + eAbility);
        }
    }

    public static MysteryBoxController createRandomMysteryBoxDefault() {
        return createRandom(EAbility.randomAll());
    }

    public static MysteryBoxController createFreezeTime() {
        AbstractFactoryMysteryBox factory = new ConcreteFactoryEasyMysteryBox();
        final var model = factory.createFreezeTime();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createKillMosquitoes() {
        AbstractFactoryMysteryBox factory = new ConcreteFactoryEasyMysteryBox();
        final var model = factory.createKillMosquitoes();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createScore() {
        AbstractFactoryMysteryBox factory = new ConcreteFactoryEasyMysteryBox();
        final var model = factory.createScore();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }

    public static MysteryBoxController createSpeed() {
        AbstractFactoryMysteryBox factory = new ConcreteFactoryEasyMysteryBox();
        final var model = factory.createSpeedUp();
        final var view = StaticFactoryEntityBlock.createMysteryBox(model.getPosition(), model.getDimension());

        return new MysteryBoxControllerImpl(model, view);
    }
}
