package vg.model.mysteryBox;

import vg.utils.path.PathImageMysteryBox;

public abstract class AbstractAbility {
    protected final String pathImage;
    protected final String pathReveled;

    public AbstractAbility(String pathReveled) {
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.pathReveled = pathReveled;
    }
}
