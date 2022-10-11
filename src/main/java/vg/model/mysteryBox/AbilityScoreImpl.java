package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilityScore;

public class AbilityScoreImpl extends AbstractAbilityInstant implements AbilityScore {

    private final int scoreIncrease;

    public AbilityScoreImpl(int scoreIncrease) {
        this.scoreIncrease = scoreIncrease;
    }

    // TODO
    @Override
    public void increaseScore() {
    }
}
