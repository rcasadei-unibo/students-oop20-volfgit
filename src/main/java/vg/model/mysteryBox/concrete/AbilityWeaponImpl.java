package vg.model.mysteryBox.concrete;

import vg.model.mysteryBox.AbstractAbilityDurable;
import vg.model.mysteryBox.EAbility;
import vg.model.mysteryBox.ability.AbilityWeapon;
import vg.utils.path.PathImageMysteryBox;

public class AbilityWeaponImpl extends AbstractAbilityDurable implements AbilityWeapon {

    private final boolean canHitBoss;

    public AbilityWeaponImpl(EAbility idAbility, double duration, boolean canHitBoss) {
        super(idAbility, duration);
        this.canHitBoss = canHitBoss;

        if(canHitBoss) {
            this.pathImage = PathImageMysteryBox.MYSTERY_BOSS;
        }
    }

    @Override
    public void startActivateWeapon() {
      //  super.onStart(this);
    }



}
