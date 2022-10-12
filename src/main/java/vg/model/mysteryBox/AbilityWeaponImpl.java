package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilityWeapon;

public class AbilityWeaponImpl extends AbstractAbilityDurable implements AbilityWeapon {

    private final boolean canHitBoss;

    public AbilityWeaponImpl(int durationMillis, boolean canHitBoss) {
        super(durationMillis);
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
