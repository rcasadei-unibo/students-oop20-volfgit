package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.concrete.AbilityWeaponImpl;
import vg.model.mysteryBox.ability.AbilityWeapon;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryWeaponAbility {

    public static AbilityWeapon createWeaponForMosquitoes() {
        return new AbilityWeaponImpl(PathImageMysteryBox.COIN_WEAPON_MOQUETOES, 200, false);
    }

    public static AbilityWeapon createWeaponForBoss() {
        return new AbilityWeaponImpl(PathImageMysteryBox.COIN_WEAPON_BOSS, 500, true);
    }

}
