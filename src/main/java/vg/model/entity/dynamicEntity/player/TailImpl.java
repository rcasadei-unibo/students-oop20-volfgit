package vg.model.entity.dynamicEntity.player;

import com.google.common.base.Optional;
import vg.utils.Direction;
import vg.utils.V2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
    public Optional<V2D> getLastCoordinate() {
        if (this.coordinates.size() > 0) {
            return Optional.of(this.coordinates.get(this.coordinates.size() - 1));
        } else {
            return Optional.absent();
        }
    }

    @Override
    public void addPoint(final V2D point) {
        if (!this.coordinates.contains(point)) {
            this.coordinates.add(point);
        }
    }

    @Override
    public List<V2D> getVertex() {
        List<V2D> vertex = new ArrayList<>();
        if (!this.coordinates.isEmpty()) {
            Iterator<V2D> it = this.coordinates.iterator();
            Direction prevDir = Direction.NONE;
            V2D prev = it.next();
            vertex.add(prev);
            while (it.hasNext()) {
                V2D next = it.next();
                //if prev direction and current are different, it means that
                // direction changed so "next" V2D is a vector
                Direction diffDir = getDirection(next.diff(prev));
                if (prevDir != diffDir && diffDir != Direction.NONE) {
                    vertex.add(next);
                    prevDir = diffDir;
                }
                prev = next;
            }
        }
        return vertex;
    }

    private Direction getDirection(final V2D vector) {
        V2D vec = vector.getSingVector();
        if (vec.equals(Direction.DOWN.getVector())) {
            return Direction.DOWN;
        } else if (vec.equals(Direction.UP.getVector())) {
            return Direction.UP;
        } else if (vec.equals(Direction.LEFT.getVector())) {
            return Direction.LEFT;
        } else if (vec.equals(Direction.RIGHT.getVector())) {
            return Direction.RIGHT;
        } else {
            return Direction.NONE;
        }
    }
}
