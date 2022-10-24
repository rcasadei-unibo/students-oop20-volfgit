package vg.model.mystery_box.factory;

import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityFreezeTimeImpl;
import vg.model.mystery_box.concrete.AbilitySpeedImpl;

public class StaticFactoryAbilityDurable {

    public static AbilityInTheBox createFreezeTime() {
        return new AbilityFreezeTimeImpl(EAbility.FREEZE_TIME);
    }

    public static AbilityInTheBox createSpeedUp() {
        return new AbilitySpeedImpl(EAbility.SPEED_UP);
    }

}
