package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityDurable;
import vg.model.mysteryBox.ability.AbilityWeapon;

public class AbilityWeaponImpl extends AbstractAbilityDurable implements AbilityWeapon {

    private final boolean canHitBoss;

    public AbilityWeaponImpl(String pathReveled, int durationMillis, boolean canHitBoss) {
        super(pathReveled, durationMillis);
        this.canHitBoss = canHitBoss;
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
