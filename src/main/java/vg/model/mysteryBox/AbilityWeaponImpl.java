package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilityWeapon;

public class AbilityWeaponImpl extends AbstractAbilityDurable implements AbilityWeapon {

    public AbilityWeaponImpl(int durationMillis) {
        super(durationMillis);
    }

    @Override
    public void startActivateWeapon() {
        super.onStart(this);
    }

    @Override
    public void functionCallOnStart() {

    }

    @Override
    public void functionCallOnEnd() {

    }


}
