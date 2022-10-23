package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.AbstractAbilityInstant;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;

public class AbilityKillMosquitoesImpl extends AbstractAbilityInstant implements AbilityInTheBox {


    public AbilityKillMosquitoesImpl(final EAbility idAbility) {
        super(idAbility);
    }

    @Override
    public void activate(final Stage<V2D> stage) {
        stage.getToDestroySet().addAll(stage.getDynamicEntitySet());
    }
}
