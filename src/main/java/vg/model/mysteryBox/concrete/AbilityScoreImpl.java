package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityInstant;
import vg.model.mysteryBox.ability.AbilityScore;

public class AbilityScoreImpl extends AbstractAbilityInstant implements AbilityScore {

    private final int scoreIncrease;

    public AbilityScoreImpl(String pathReveled, int scoreIncrease) {
        super(pathReveled);
        this.scoreIncrease = scoreIncrease;
    }

    // TODO
    @Override
    public void increaseScore() {
    }
}
