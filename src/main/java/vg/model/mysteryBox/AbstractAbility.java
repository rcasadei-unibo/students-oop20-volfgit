package vg.model.mysteryBox;

import vg.utils.path.PathImageMysteryBox;

public abstract class AbstractAbility {
    protected final String pathImage;
    protected final EAbility idAbility;

    public AbstractAbility(EAbility idAbility) {
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.idAbility = idAbility;
    }
}
