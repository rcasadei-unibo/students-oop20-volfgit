package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.concrete.AbilityWeaponImpl;
import vg.model.mysteryBox.ability.AbilityWeapon;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryWeaponAbility {

    public static AbilityWeapon createWeaponForMosquitoes() {
        return new AbilityWeaponImpl(EAbility.WeaponMosquitoes, 200, false);
    }

    public static AbilityWeapon createWeaponForBoss() {
        return new AbilityWeaponImpl(EAbility.WeaponBoss, 500, true);
    }

}
