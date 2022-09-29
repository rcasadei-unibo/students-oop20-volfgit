package vg.model;

import vg.utils.V2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TailImpl implements Tail{
    private List<V2D> coordinates;

    public static Tail emptyTail() {
        return new TailImpl();
    }
    private TailImpl(){
    }

    @Override
    public List<V2D> getCooridnates() {
        return Collections.unmodifiableList(this.coordinates);
    }

    @Override
    public void resetTail() {
        this.coordinates = new ArrayList<>();
    }

    @Override
    public V2D getLastCoordinate() {
        return this.coordinates.get(this.coordinates.size()-1);
    }
}
