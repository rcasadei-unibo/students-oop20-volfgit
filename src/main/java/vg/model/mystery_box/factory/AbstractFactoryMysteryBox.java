package vg.model.mystery_box.factory;

import vg.model.mystery_box.AbilityInTheBox;

public abstract class AbstractFactoryMysteryBox {
    public abstract AbilityInTheBox createFreezeTime();

    public abstract AbilityInTheBox createSpeedUp();

    public abstract AbilityInTheBox createScore();

    public abstract AbilityInTheBox createKillMosquitoes();
}
