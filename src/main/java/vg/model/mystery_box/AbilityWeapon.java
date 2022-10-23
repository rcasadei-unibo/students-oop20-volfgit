package vg.model.mystery_box;

import vg.model.timedObject.TimedObject;

public interface AbilityWeapon extends AbilityInTheBox, TimedObject {
    void startActivateWeapon();
}
