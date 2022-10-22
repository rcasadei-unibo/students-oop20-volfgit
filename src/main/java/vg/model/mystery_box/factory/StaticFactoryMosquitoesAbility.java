package vg.model.mystery_box.factory;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityKillMosquitoesImpl;
import vg.model.mystery_box.ability.AbilityKillMosquitoes;

public class StaticFactoryMosquitoesAbility {

    public static AbilityKillMosquitoes createKillMosquitoes() {
        return new AbilityKillMosquitoesImpl(EAbility.KillAllMosquitoes);
    }





}
