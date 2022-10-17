package vg.model.mysteryBox.ability;

import vg.model.mysteryBox.AbilityDuration;
import vg.model.mysteryBox.AbilityInTheBox;

public interface AbilityFreezeTime extends AbilityInTheBox, AbilityDuration {
    public void startFreezeTime();
}
