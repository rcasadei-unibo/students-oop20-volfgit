package vg.model.mystery_box;

import javafx.geometry.Dimension2D;
import vg.model.entity.staticEntity.StaticEntity;
import vg.model.mystery_box.logic_blink.LogicBlink;
import vg.model.mystery_box.logic_blink.LogicBlinkImpl;
import vg.utils.V2D;
import vg.utils.path.PathImageMysteryBox;

/**
 * AbstractAbility is the base class for all the abilities.
 */
public abstract class AbstractAbility extends StaticEntity {
    private static final Dimension2D DIMENSION_BOX = new Dimension2D(60, 60);
    private static final V2D INIT_POSITION = new V2D(0, 0);

    public final Dimension2D dimension;
    protected String pathImage;
    private final EAbility idAbility;
    private final LogicBlink logicBlink;


    public AbstractAbility(EAbility idAbility) {
        super(INIT_POSITION, (int) (DIMENSION_BOX.getWidth() / 2));
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.dimension = DIMENSION_BOX;
        this.idAbility = idAbility;
        this.logicBlink = new LogicBlinkImpl();
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
        return this.logicBlink.isBlinking();
    }

    public boolean isShow() {
        return this.logicBlink.isShow();
    }

    public void setBlinking(boolean isBlinking) {
        this.logicBlink.setBlinking(isBlinking);
    }

    public void updateBlinking(long elapsedTime){
        this.logicBlink.updateBlinking(elapsedTime);
    }

}
