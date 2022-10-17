package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.concrete.AbilitySpeedImpl;
import vg.model.mysteryBox.ability.AbilitySpeed;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactorySpeedAbility {

    public static AbilitySpeed createSmallSpeed() {
        return new AbilitySpeedImpl(PathImageMysteryBox.COIN_SPEED, 100);
    }

    public static AbilitySpeed createMediumSpeed() {
        return new AbilitySpeedImpl(PathImageMysteryBox.COIN_SPEED, 200);
    }

    public static AbilitySpeed createBigSpeed() {
        return new AbilitySpeedImpl(PathImageMysteryBox.COIN_SPEED, 300);
    }

}
