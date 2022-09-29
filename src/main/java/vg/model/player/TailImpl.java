package vg.model.player;

import vg.utils.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class TailImpl implements Tail{
    private List<Position> coordinates;

    public static Tail emptyTail() {
        return new TailImpl();
    }
    private TailImpl(){
    }

    @Override
    public List<Position> getCooridnates() {
        return Collections.unmodifiableList(this.coordinates);
    }

    @Override
    public void resetTail() {
        this.coordinates = new ArrayList<>();
    }

    @Override
    public Position getLastCoordinate() {
        return this.coordinates.get(this.coordinates.size()-1);
    }
}
