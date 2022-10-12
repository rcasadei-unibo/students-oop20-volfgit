package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.AbilityFreezeTimeImpl;
import vg.model.mysteryBox.ability.AbilityFreezeTime;

public class StaticFactoryFreezeTimeAbility {

    public static AbilityFreezeTime createSmallTime() {
        return new AbilityFreezeTimeImpl(500);
    }

    public static AbilityFreezeTime createMediumTime() {
        return new AbilityFreezeTimeImpl(1000);
    }

    public static AbilityFreezeTime createBigTime() {
        return new AbilityFreezeTimeImpl(2000);
    }

}
