package vg.model.mystery_box;

import javafx.geometry.Dimension2D;
import vg.model.entity.Entity;
import vg.utils.V2D;

/**
 * This class represents the ability of the game.
 */
public interface AbilityInTheBox extends Entity {
    /**
     *   This method is used to activate the ability.
     *
     */
    EAbility getIdAbility();

    /**
     *
     * @return
     */
    V2D getPosition();
    Dimension2D getDimension();
    String getPathImage();
    boolean isBlinking();

    /**
     *  This method is used to activate the ability.
     *  @param isBlinking
     */


    void setBlinking(boolean isBlinking);

    void setPosition(V2D position);

    void updateBlinking(long elapsedTime);

    boolean isShow();

}
