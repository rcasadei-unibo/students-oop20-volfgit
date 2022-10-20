package vg.model.mysteryBox.ability;

import vg.model.mysteryBox.AbilityInTheBox;
import vg.model.timedObject.TimedObject;

public interface AbilityWeapon extends AbilityInTheBox, TimedObject {

    public void startActivateWeapon();

}
