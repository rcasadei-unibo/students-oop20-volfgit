package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;
import vg.utils.path.PathImageMysteryBox;


public abstract class AbstractAbility extends StaticEntity {
    private static final Dimension2D DIMENSION_BOX = new Dimension2D(60, 60);
    private static final V2D INIT_POSITION = new V2D(0, 0);

    public final Dimension2D dimension;
    protected String pathImage;
    private final EAbility idAbility;
    private boolean isBlinking;


    public AbstractAbility(EAbility idAbility) {
        super(INIT_POSITION, (int) (DIMENSION_BOX.getWidth() * 2));
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.dimension = DIMENSION_BOX;
        this.idAbility = idAbility;
        this.isBlinking = false;
    }

    public EAbility getIdAbility() {
        return this.idAbility;
    }
    public Dimension2D getDimension() {
        return this.dimension;
    }

    public String getPathImage() {
        return this.pathImage;
    }

    public boolean isBlinking() {
        return this.isBlinking;
    }

    public void setBlinking(boolean isBlinking) {
        this.isBlinking = isBlinking;
    }
}
