package vg.model.mystery_box;

import javafx.geometry.Dimension2D;
import vg.model.Stage;
import vg.model.entity.Entity;
import vg.utils.V2D;

/**
 * This class represents the ability of the game.
 */
public interface AbilityInTheBox extends Entity {
    /**
     *   This method is used to identify the ability.
     *   @return the id of the ability.
     */
    EAbility getIdAbility();
    ETypeAbility getTypeAbility();
    /**
     * This method is used to get the position of the box.
     * @return the position of the box.
     */
    @Override
    V2D getPosition();
    /**
     * This method is used to get the dimension of the box.
     * @return the dimension of the box.
     */
    Dimension2D getDimension();


    int getRadius();
    /**
     * This method is used to get the path of the image of the ability.
     * @return the path of the image of the ability.
     */
    String getPathImage();

    /**
     * This method is used to verify if the blink is active.
     * @return true if the blink is active, false otherwise.
     */
    boolean isBlinking();

    /**
     * This method is used to update the blinking.
     * @param isBlinking defines if the ability is blinking.
     */
    void setBlinking(boolean isBlinking);

    /**
     * This method is used to set the position.
     * @param position defines the position of the box.
     */
    void setPosition(V2D position);

    /**
     * This method is used to update the blinking.
     * @param elapsedTime defines the time elapsed.
     */
    void updateBlinking(long elapsedTime);

    /**
     * This method is used if the box is shown.
     * @return true if the box is shown, false otherwise.
     */
    boolean isShow();

    void activate(Stage<V2D> stage);
    boolean isActivated();

    void show();
    void hide();
}
