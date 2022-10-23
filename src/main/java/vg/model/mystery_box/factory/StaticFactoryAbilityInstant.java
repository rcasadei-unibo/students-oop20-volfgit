package vg.model.mystery_box.factory;

import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityKillMosquitoesImpl;
import vg.model.mystery_box.concrete.AbilityScoreImpl;

public class StaticFactoryAbilityInstant {

    public static AbilityInTheBox createScore() {
        return new AbilityScoreImpl(EAbility.SCORE, 100);
    }

    public static AbilityInTheBox createKillMosquitoes() {
        return new AbilityKillMosquitoesImpl(EAbility.KILL_ALL_MOSQUITOES);
    }

}