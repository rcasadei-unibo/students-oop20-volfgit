package vg.model.mystery_box.concrete;

import vg.model.Stage;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.mystery_box.AbilityDurable;
import vg.model.mystery_box.AbstractAbilityDurable;
import vg.model.mystery_box.EAbility;
import vg.utils.V2D;


public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityDurable {
    private static final double DURATION = 5000;

    public AbilityFreezeTimeImpl(final EAbility idAbility) {
        super(idAbility, DURATION);
    }

    @Override
    public void activate(final Stage<V2D> stage) {
        this.activated();
        stage.getDynamicEntitySet().forEach(enemy -> {
            enemy.saveMySpeed();
            enemy.setSpeed(new V2D(0, 0));
        });
    }

    @Override
    public void deActivate(final Stage<V2D> stage) {
        stage.getDynamicEntitySet().forEach(DynamicEntity::restoreMySpeed);
    }
}
