package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityInstant;
import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.ability.AbilityScore;

public class AbilityScoreImpl extends AbstractAbilityInstant implements AbilityScore {

    private final int scoreIncrease;

    public AbilityScoreImpl(EAbility idAbility, int scoreIncrease) {
        super(idAbility);
        this.scoreIncrease = scoreIncrease;
    }

    // TODO
    @Override
    public void increaseScore() {
    }
}
