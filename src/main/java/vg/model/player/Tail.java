package vg.model.player;

import vg.utils.Position;

import java.util.List;
import java.util.Optional;


public interface Tail {

    List<Position> getCooridnates();
    void resetTail();
    Position getLastCoordinate();

}
