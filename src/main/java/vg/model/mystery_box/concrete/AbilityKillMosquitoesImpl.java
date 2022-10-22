package vg.model.mystery_box.concrete;

import vg.model.mystery_box.AbstractAbilityInstant;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.ability.AbilityKillMosquitoes;

public class AbilityKillMosquitoesImpl extends AbstractAbilityInstant implements AbilityKillMosquitoes {


    public AbilityKillMosquitoesImpl(final EAbility idAbility) {
        super(idAbility);
    }

    @Override
    public void oneShotMosquitoes() {

    }
}
