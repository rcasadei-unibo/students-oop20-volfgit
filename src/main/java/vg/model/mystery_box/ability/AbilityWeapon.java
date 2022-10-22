package vg.model.mystery_box.ability;

import vg.model.mystery_box.AbilityInTheBox;
import vg.model.timedObject.TimedObject;

public interface AbilityWeapon extends AbilityInTheBox, TimedObject {
    void startActivateWeapon();
}
