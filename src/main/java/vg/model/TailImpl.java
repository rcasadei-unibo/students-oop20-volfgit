package vg.model;

import vg.utils.V2D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TailImpl implements Tail {
    /**
     * List of all extremity point of segment.
     * */
    private List<V2D> coordinates;

    public static Tail emptyTail() {
        return new TailImpl();
    }
    private TailImpl() {
        this.coordinates = new ArrayList<>();
    }
    @Override
    public List<V2D> getCoordinates() {
        return Collections.unmodifiableList(this.coordinates);
    }

    @Override
    public void resetTail() {
        this.coordinates = new ArrayList<>();
    }

    @Override
    public V2D getLastCoordinate() {
        return this.coordinates.get(this.coordinates.size() - 1);
    }

    @Override
    public void addPoint(final V2D point) {
        this.coordinates.add(point);
    }
}
