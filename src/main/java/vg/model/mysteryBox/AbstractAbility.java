package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;
import vg.utils.path.PathImageMysteryBox;


public abstract class AbstractAbility extends StaticEntity {
    private static final double WIDTH = 60;
    private static final double HEIGHT = 60;

    public final Dimension2D dimension;
    protected String pathImage;
    protected final EAbility idAbility;

    public AbstractAbility(EAbility idAbility) {
        super(new V2D(0, 0), (int) (WIDTH * 2));
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
