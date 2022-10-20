package vg.model.entity.dynamicEntity.player;

import com.google.common.base.Optional;
import vg.utils.V2D;
import java.io.Serializable;
import java.util.List;

public interface Tail extends Serializable {

    List<V2D> getCoordinates();
    void resetTail();
    //TODO: better return Optional<V2D>
    /*Optional<*/V2D/*>*/ getLastCoordinate();
    void addPoint(V2D point);

}
