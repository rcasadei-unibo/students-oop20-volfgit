package vg.model.mysteryBox.factory;

import vg.model.mysteryBox.concrete.AbilityScoreImpl;
import vg.model.mysteryBox.ability.AbilityScore;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryScoreAbility {


    public static AbilityScore createScoreSmall() {
        return new AbilityScoreImpl(PathImageMysteryBox.COIN_SCORE, 100);
    }

    public static AbilityScore createScoreMedium() {
        return new AbilityScoreImpl(PathImageMysteryBox.COIN_SCORE, 200);
    }

    public static AbilityScore createScoreBig() {
        return new AbilityScoreImpl(PathImageMysteryBox.COIN_SCORE, 300);
    }


}
