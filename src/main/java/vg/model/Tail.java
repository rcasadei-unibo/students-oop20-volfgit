package vg.model;

import vg.utils.V2D;

import java.util.List;
import java.util.Optional;


public interface Tail {

    List<V2D> getCooridnates();
    void resetTail();
    V2D getLastCoordinate();

}
