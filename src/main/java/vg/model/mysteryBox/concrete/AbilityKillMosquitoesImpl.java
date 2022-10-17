package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityInstant;
import vg.model.mysteryBox.ability.AbilityKillMosquitoes;

public class AbilityKillMosquitoesImpl extends AbstractAbilityInstant implements AbilityKillMosquitoes {


    public AbilityKillMosquitoesImpl(String pathReveled) {
        super(pathReveled);
    }

    @Override
    public void oneShotMosquitoes() {

    }
}
