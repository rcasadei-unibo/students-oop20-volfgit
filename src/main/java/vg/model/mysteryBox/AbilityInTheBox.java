package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;

public interface AbilityInTheBox {
    public EAbility getIdAbility();
    public V2D getPosition();
    public Dimension2D getDimension();
    public String getPathImage();
    public boolean isBlinking();

    public void setBlinking(boolean isBlinking);

    public void setPosition(V2D position);

    public void updateBlinking(long elapsedTime);

    public boolean isShow();
}
