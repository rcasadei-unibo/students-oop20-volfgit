package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityDurable;
import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.ability.AbilityFreezeTime;

public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityFreezeTime {

    public AbilityFreezeTimeImpl(EAbility idAbility, int duration) {
        super(idAbility, duration);
    }

    @Override
    public void startFreezeTime() {
        super.onStart(this);
    }
    @Override
    public void functionCallOnStart() {

    }
    @Override
    public void functionCallOnEnd() {

    }

}