package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.AbilityScoreImpl;
import vg.model.mysteryBox.ability.AbilityScore;

public class StaticFactoryScoreAbility {


    public static AbilityScore createScoreSmall() {
        return new AbilityScoreImpl(100);
    }

    public static AbilityScore createScoreMedium() {
        return new AbilityScoreImpl(200);
    }

    public static AbilityScore createScoreBig() {
        return new AbilityScoreImpl(300);
    }


}
