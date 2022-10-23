package vg.model.mystery_box;

import vg.model.Stage;
import vg.model.timedObject.TimedObject;
import vg.utils.V2D;

public interface AbilityDurable extends AbilityInTheBox, TimedObject {
    void deActivate(Stage<V2D> stage);
}
