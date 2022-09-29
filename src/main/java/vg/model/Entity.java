package vg.model;

import vg.utils.Direction;
import vg.utils.Position;

public interface Entity {
    void move(Direction direction);
    Position getPosition();
    //Shape getShape();
}
