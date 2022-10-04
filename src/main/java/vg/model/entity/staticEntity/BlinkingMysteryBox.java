package vg.model.entity.staticEntity;

import vg.model.timedObject.BonusImpl;
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

    /**
     * Returns if the box is hiding.
     * @return true if the box is hiding, false otherwise
     */
    public boolean isHide() {
        return hide;
    }

    /**
     * Sets the visibility state of the box.
     * @param hide true if the box is hiding, false if the box is visible
     */
    public void setHide(final boolean hide) {
        this.hide = hide;
    }

    /**
     * Returns if the box can appear or not. If true then the
     * box has the "space" to appear, if false then something
     * is traveling on the same position of the box or the
     * player created a wall.
     * @return true if the box can appear, false otherwise
     */
    public boolean isAppearance() {
        return this.appearance;
    }

    /**
     * Sets the appearance boolean: true if the box can appear,
     * false otherwise.
     * @param appearance the state of the boolean to set to
     */
    public void setAppearance(final boolean appearance) {
        this.appearance = appearance;
    }

    /**
     * This method change the state of the box from hiding
     * to not hiding and vice-versa. It will check if the
     * box can actually appear again through the {@link #appearance}
     * boolean.
     */
    public void changeState() {
        if (isHide()) {
            setHide(!isAppearance());
        } else {
            setHide(!isHide());
        }
    }
}
