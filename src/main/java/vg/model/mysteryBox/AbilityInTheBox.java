package vg.model.mysteryBox;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;

public interface AbilityInTheBox {

    public Dimension2D getDimension();
    public V2D getPosition();
    public void setPosition(V2D position);

    public String getPathImage();
}
