package vg.model.mystery_box;

import javafx.geometry.Dimension2D;
import vg.model.entity.Entity;
import vg.utils.V2D;


public interface AbilityInTheBox extends Entity {
    EAbility getIdAbility();
    V2D getPosition();
    Dimension2D getDimension();
    String getPathImage();
    boolean isBlinking();

    void setBlinking(boolean isBlinking);

    void setPosition(V2D position);

    void updateBlinking(long elapsedTime);

    boolean isShow();

}
