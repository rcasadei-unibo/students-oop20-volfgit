package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.utils.path.PathImageMysteryBox;


public abstract class AbstractAbility {
    private static final double WIDTH = 60;
    private static final double HEIGHT = 60;

    public final Dimension2D dimension;
    protected String pathImage;
    protected final EAbility idAbility;

    public AbstractAbility(EAbility idAbility) {
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.dimension = new Dimension2D(WIDTH, HEIGHT);
        this.idAbility = idAbility;
    }

    public Dimension2D getDimension() {
        return this.dimension;
    }

    public String getPathImage() {
        return this.pathImage;
    }
}
