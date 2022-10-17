package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.concrete.AbilityFreezeTimeImpl;
import vg.model.mysteryBox.ability.AbilityFreezeTime;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryFreezeTimeAbility {

    public static AbilityFreezeTime createSmallTime() {
        return new AbilityFreezeTimeImpl(PathImageMysteryBox.COIN_TIME, 500);
    }

    public static AbilityFreezeTime createMediumTime() {
        return new AbilityFreezeTimeImpl(PathImageMysteryBox.COIN_TIME, 1000);
    }

    public static AbilityFreezeTime createBigTime() {
        return new AbilityFreezeTimeImpl(PathImageMysteryBox.COIN_TIME, 2000);
    }

}
