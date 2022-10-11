package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilityFreezeTime;

public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityFreezeTime {

    public AbilityFreezeTimeImpl(int duration) {
        super(duration);
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
