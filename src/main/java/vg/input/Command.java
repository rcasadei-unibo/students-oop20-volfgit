package vg.input;

import vg.model.Map;
import vg.utils.Direction;

public interface Command {
    void executeCommandOn(Map map, Direction dir);
}
