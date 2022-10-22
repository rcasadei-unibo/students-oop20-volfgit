package vg.model.mystery_box.concrete;

import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.ability.AbilityFreezeTime;


public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityFreezeTime {

    public AbilityFreezeTimeImpl(final EAbility idAbility, final double duration) {
        super(idAbility, duration);

    }

    @Override
    public void startFreezeTime() {
       // super.onStart(this);
    }
}
