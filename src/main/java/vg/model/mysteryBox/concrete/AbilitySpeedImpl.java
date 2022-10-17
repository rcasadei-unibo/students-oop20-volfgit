package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityDurable;
import vg.model.mysteryBox.ability.AbilitySpeed;

public class AbilitySpeedImpl extends AbstractAbilityDurable implements AbilitySpeed {

    public AbilitySpeedImpl(String pathReveled, int duration) {
        super(pathReveled, duration);
    }


    @Override
    public void startSpeed() {
        super.onStart(this);
    }

    @Override
    public void functionCallOnStart() {

    }

    @Override
    public void functionCallOnEnd() {

    }


}
