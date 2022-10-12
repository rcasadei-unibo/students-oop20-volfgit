package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.AbilitySpeedImpl;
import vg.model.mysteryBox.ability.AbilitySpeed;

public class StaticFactorySpeedAbility {

    public static AbilitySpeed createSmallSpeed() {
        return new AbilitySpeedImpl(100);
    }

    public static AbilitySpeed createMediumSpeed() {
        return new AbilitySpeedImpl(200);
    }

    public static AbilitySpeed createBigSpeed() {
        return new AbilitySpeedImpl(300);
    }

}
