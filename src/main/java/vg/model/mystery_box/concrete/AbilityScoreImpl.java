package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.mystery_box.AbstractAbilityInstant;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;

public class AbilityScoreImpl extends AbstractAbilityInstant {
    private static final long serialVersionUID = 1L;

    private static final int SCORE_INCREASE = 200;
    private final int scoreIncrease;

    public AbilityScoreImpl(final EAbility idAbility) {
        super(idAbility);
        this.scoreIncrease = SCORE_INCREASE;
    }

    @Override
    public void activate(final Stage<V2D> stage) {
        this.activated();
        final int currentScore = stage.getCurrentScore();
        stage.setCurrentScore(currentScore + scoreIncrease);
    }
}
