package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.AbilityKillMosquitoesImpl;
import vg.model.mysteryBox.ability.AbilityKillMosquitoes;

public class StaticFactoryMosquitoesAbility {

    public static AbilityKillMosquitoes createKillMosquitoes() {
        return new AbilityKillMosquitoesImpl();
    }





}
