package vg.model.entity.staticEntity;

import vg.model.bonus.BonusImpl;
import vg.utils.V2D;

/**
 * This will generate mystery boxes that will disappear from time
 * to time. Then they will appear back in the same spot if they are
 * able to. Besides from this it is a normal {@link MysteryBox}
 */
public class BlinkingMysteryBox extends MysteryBox<BonusImpl> {

    /**
     * hide is a boolean that indicates if this mystery box is
     * visible or not.
     */
    private boolean hide;
    /**
     * appearance is a boolean that indicates if this mystery box
     * can appear after being hide. If the player is creating or
     * already created a wall where the box must appear, this will
     * be set to false and will be used to not make it appear again
     * until it is possible to.
     */
    private boolean appearance;

    /**
     * TODO find a way to link the doc of another construct as with "inheritDoc".
     * @param position the position of the mystery box
     * @param halfWidth the half of the width and the height of the box
     * @param bonus the bonus contained in this box
     */
    BlinkingMysteryBox(final V2D position, final int halfWidth, final BonusImpl bonus) {
        super(position, halfWidth, bonus);
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(final boolean hide) {
        this.hide = hide;
    }

    public boolean isAppearance() {
        return this.appearance;
    }

    public void setAppearence(final boolean appearence) {
        this.appearance = appearance;
    }

    private void changeState() {
        //TODO
    }
}
