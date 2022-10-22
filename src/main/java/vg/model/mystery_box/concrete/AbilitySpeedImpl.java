package vg.model.mystery_box.concrete;

import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.ability.AbilitySpeed;

public class AbilitySpeedImpl extends AbstractAbilityDurable implements AbilitySpeed {

    public AbilitySpeedImpl(final EAbility idAbility, final double duration) {
        super(idAbility, duration);
    }


    @Override
    public void startSpeed() {
       // super.onStart(this);
    }


}
