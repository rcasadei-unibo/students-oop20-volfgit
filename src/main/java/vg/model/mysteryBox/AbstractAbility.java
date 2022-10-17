package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.utils.path.PathImageMysteryBox;


public abstract class AbstractAbility {
    private final double WIDTH = 60;
    private final double HEIGHT = 60;

    public final Dimension2D dimension;
    protected final String pathImage;
    protected final EAbility idAbility;

    public AbstractAbility(EAbility idAbility) {
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.dimension = new Dimension2D(WIDTH, HEIGHT);
        this.idAbility = idAbility;
    }

    public Dimension2D getDimension() {
        return this.dimension;
    }
}
