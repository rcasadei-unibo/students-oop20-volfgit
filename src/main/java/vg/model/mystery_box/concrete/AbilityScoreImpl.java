package vg.model.mystery_box.concrete;

import vg.model.mystery_box.AbstractAbilityInstant;
import vg.model.mystery_box.EAbility;
import vg.model.mystery_box.ability.AbilityScore;

public class AbilityScoreImpl extends AbstractAbilityInstant implements AbilityScore {

    private final int scoreIncrease;

    public AbilityScoreImpl(final EAbility idAbility, final int scoreIncrease) {
        super(idAbility);
        this.scoreIncrease = scoreIncrease;
    }

    // TODO
    @Override
    public void increaseScore() {
    }
}
