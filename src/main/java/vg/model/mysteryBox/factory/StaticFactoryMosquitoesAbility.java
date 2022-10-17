package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.concrete.AbilityKillMosquitoesImpl;
import vg.model.mysteryBox.ability.AbilityKillMosquitoes;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryMosquitoesAbility {

    public static AbilityKillMosquitoes createKillMosquitoes() {
        return new AbilityKillMosquitoesImpl(EAbility.KillAllMosquitoes);
    }





}
