package vg.model.mystery_box.factory;

import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.concrete.AbilityScoreImpl;
import vg.model.mystery_box.ability.AbilityScore;

public class StaticFactoryScoreAbility {


    public static AbilityScore createScoreSmall() {
        return new AbilityScoreImpl(EAbility.Score, 100);
    }

    public static AbilityScore createScoreMedium() {
        return new AbilityScoreImpl(EAbility.Score, 200);
    }

    public static AbilityScore createScoreBig() {
        return new AbilityScoreImpl(EAbility.Score, 300);
    }


}
