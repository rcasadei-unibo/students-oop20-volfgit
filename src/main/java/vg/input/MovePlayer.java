package vg.input;

import vg.model.Map;
import vg.utils.Direction;

public class MovePlayer implements Command {

    @Override
    public void executeCommandOn(final Map map, final Direction dir) {
        map.getPlayer().move(dir);
    }
}
