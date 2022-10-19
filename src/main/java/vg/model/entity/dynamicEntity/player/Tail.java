package vg.model.entity.dynamicEntity.player;

import vg.utils.V2D;

import java.io.Serializable;
import java.util.List;

public interface Tail extends Serializable {

    List<V2D> getCoordinates();
    void resetTail();
    V2D getLastCoordinate();
    void addPoint(V2D point);

}
