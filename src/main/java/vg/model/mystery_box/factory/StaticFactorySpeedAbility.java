package vg.model.mystery_box.factory;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilitySpeedImpl;
import vg.model.mystery_box.ability.AbilitySpeed;

public class StaticFactorySpeedAbility {

    public static AbilitySpeed createSmallSpeed() {
        return new AbilitySpeedImpl(EAbility.SpeedUp, 100);
    }

    public static AbilitySpeed createMediumSpeed() {
        return new AbilitySpeedImpl(EAbility.SpeedUp, 200);
    }

    public static AbilitySpeed createBigSpeed() {
        return new AbilitySpeedImpl(EAbility.SpeedUp, 300);
    }

}
