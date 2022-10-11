package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilitySpeed;

public class AbilitySpeedImpl extends AbstractAbilityDurable implements AbilitySpeed {

    public AbilitySpeedImpl(int duration) {
        super(duration);
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
