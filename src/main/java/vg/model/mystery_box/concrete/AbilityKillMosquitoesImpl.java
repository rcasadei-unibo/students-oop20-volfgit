package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.mystery_box.AbstractAbilityInstant;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;

public class AbilityKillMosquitoesImpl extends AbstractAbilityInstant {


    public AbilityKillMosquitoesImpl(final EAbility idAbility) {
        super(idAbility);
    }

    @Override
    public void activate(final Stage<V2D> stage) {
        this.activated();
        stage.getToDestroySet().addAll(stage.getDynamicEntitySet());
    }
}
