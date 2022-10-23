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
    private final Dimension2D dimension;
    protected String pathImage;
    private final EAbility idAbility;
    private final ETypeAbility typeAbility;
    private final LogicBlink logicBlink;


    public AbstractAbility(final EAbility idAbility, final ETypeAbility typeAbility) {
        super(INIT_POSITION, (int) (DIMENSION_BOX.getWidth() / 2));
        this.pathImage = PathImageMysteryBox.MYSTERY_BOX;
        this.dimension = DIMENSION_BOX;
        this.idAbility = idAbility;
        this.typeAbility = typeAbility;
        this.logicBlink = new LogicBlinkImpl();
    }

    /**
     * This method is used to get the id of the ability.
     * @return the id of the ability.
     */
    public EAbility getIdAbility() {
        return this.idAbility;
    }

    public ETypeAbility getTypeAbility() {
        return this.typeAbility;
    }
    /**
     * This method is used to get the dimension of the box.
     * @return the dimension of the box.
     */
    public Dimension2D getDimension() {
        return this.dimension;
    }
    /**
     * This method is used to get the path of the image of the ability.
     * @return the path of the image of the ability.
     */
    public String getPathImage() {
        return this.pathImage;
    }
    /**
     * This method is used to verify if the blink is active.
     * @return true if the blink is active, false otherwise.
     */
    public boolean isBlinking() {
        return this.logicBlink.isBlinking();
    }
    /**
     * This method is used to verify if the box is shown.
     * @return true if the box is shown, false otherwise.
     */
    public boolean isShow() {
        return this.logicBlink.isShow();
    }
    /**
     * This method is used to update the blinking.
     * @param isBlinking defines if the ability is blinking.
     */
    public void setBlinking(final boolean isBlinking) {
        this.logicBlink.setBlinking(isBlinking);
    }
    /**
     * This method is used to update the blinking.
     * @param elapsedTime defines the time elapsed.
     */
    public void updateBlinking(final long elapsedTime) {
        this.logicBlink.updateBlinking(elapsedTime);
    }

}
