package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityInstant;
import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.ability.AbilityKillMosquitoes;

public class AbilityKillMosquitoesImpl extends AbstractAbilityInstant implements AbilityKillMosquitoes {


    public AbilityKillMosquitoesImpl(EAbility idAbility) {
        super(idAbility);
    }

    @Override
    public void oneShotMosquitoes() {

    }
}
