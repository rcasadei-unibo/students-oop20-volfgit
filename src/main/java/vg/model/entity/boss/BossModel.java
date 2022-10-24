package vg.model.entity.boss;

import javafx.geometry.Dimension2D;
import vg.model.entity.Entity;
import vg.utils.Shape;
import vg.utils.V2D;

public interface BossModel extends Entity {

    int getRadius();

    Dimension2D getDimension();

    void move();

    void saveMySpeed();

    void setSpeed(V2D v2D);

    void restoreMySpeed();

    void setPosition(V2D v2dPosition);

    V2D getSpeed();

    Shape getShape();
}
