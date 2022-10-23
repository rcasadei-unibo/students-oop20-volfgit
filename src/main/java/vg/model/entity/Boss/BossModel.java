package vg.model.entity.Boss;

import javafx.geometry.Dimension2D;
import vg.model.entity.Entity;

public interface BossModel extends Entity {

    int getRadius();

    Dimension2D getDimension();

    void move();
}
