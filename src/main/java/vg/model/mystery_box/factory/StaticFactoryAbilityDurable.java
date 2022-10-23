package vg.model.mystery_box.factory;

import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityFreezeTimeImpl;
import vg.model.mystery_box.concrete.AbilitySpeedImpl;
import vg.model.mystery_box.concrete.AbilityWeaponImpl;

public class StaticFactoryAbilityDurable {

    public static AbilityInTheBox createFreezeTime() {
        return new AbilityFreezeTimeImpl(EAbility.FREEZE_TIME);
    }

    public static AbilityInTheBox createSpeedUp() {
        return new AbilitySpeedImpl(EAbility.SPEED_UP);
    }

    public static AbilityInTheBox createWeaponForMosquitoes() {
        return new AbilityWeaponImpl(EAbility.WEAPON_MOSQUITOES, 200, false);
    }
    public static AbilityInTheBox createWeaponForBoss() {
        return new AbilityWeaponImpl(EAbility.WEAPON_BOSS, 500, true);
    }

}
