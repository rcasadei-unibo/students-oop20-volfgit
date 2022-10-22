package vg.model.mystery_box.ability;

import vg.model.mystery_box.AbilityInTheBox;
import vg.model.timedObject.TimedObject;

public interface AbilitySpeed extends AbilityInTheBox, TimedObject {
    void startSpeed();
}
