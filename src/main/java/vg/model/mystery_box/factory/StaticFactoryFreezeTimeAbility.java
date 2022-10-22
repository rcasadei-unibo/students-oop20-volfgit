package vg.model.mystery_box.factory;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityFreezeTimeImpl;
import vg.model.mystery_box.ability.AbilityFreezeTime;

public class StaticFactoryFreezeTimeAbility {

    public static AbilityFreezeTime createSmallTime() {
        return new AbilityFreezeTimeImpl(EAbility.FreezeTime, 500);
    }

    public static AbilityFreezeTime createMediumTime() {
        return new AbilityFreezeTimeImpl(EAbility.FreezeTime, 1000);
    }

    public static AbilityFreezeTime createBigTime() {
        return new AbilityFreezeTimeImpl(EAbility.FreezeTime, 2000);
    }

}
