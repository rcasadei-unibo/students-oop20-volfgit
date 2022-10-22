package vg.model.mystery_box.factory;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityWeaponImpl;
import vg.model.mystery_box.ability.AbilityWeapon;

public class StaticFactoryWeaponAbility {

    public static AbilityWeapon createWeaponForMosquitoes() {
        return new AbilityWeaponImpl(EAbility.WeaponMosquitoes, 200, false);
    }

    public static AbilityWeapon createWeaponForBoss() {
        return new AbilityWeaponImpl(EAbility.WeaponBoss, 500, true);
    }

}
