package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mystery_box.AbilityDurable;
import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;

public class AbilitySpeedImpl extends AbstractAbilityDurable implements AbilityDurable {
    private static final double INCREASE_SPEED = 1;
    private static final double DURATION = 5000;

    private final double speedIncrease;


    public AbilitySpeedImpl(final EAbility idAbility) {
        super(idAbility, DURATION);
        this.speedIncrease = INCREASE_SPEED;
    }


    @Override
    public void activate(final Stage<V2D> stage) {
        this.activated();
        Player player = stage.getPlayer();
        V2D baseSpeed = player.getSpeed();
        V2D speedIncrease = new V2D(baseSpeed.getX() + this.speedIncrease, baseSpeed.getY() + this.speedIncrease);
        player.enableSpeedUp(speedIncrease);
    }

    @Override
    public void deActivate(final Stage<V2D> stage) {
        Player player = stage.getPlayer();
        player.disableSpeedUp();
    }
}
