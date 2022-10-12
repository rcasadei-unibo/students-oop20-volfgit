package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.AbilityWeaponImpl;
import vg.model.mysteryBox.ability.AbilityWeapon;

public class StaticFactoryWeaponAbility {

    public static AbilityWeapon createWeaponForMosquitoes() {
        return new AbilityWeaponImpl(200, false);
    }

    public static AbilityWeapon createWeaponForBoss() {
        return new AbilityWeaponImpl(500, true);
    }

}
