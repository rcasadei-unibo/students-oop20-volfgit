package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;


public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityInTheBox {

    public AbilityFreezeTimeImpl(final EAbility idAbility, final double duration) {
        super(idAbility, duration);

    }

    @Override
    public void activate(Stage<V2D> stage) {

    }
}
