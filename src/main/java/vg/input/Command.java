package vg.input;

import vg.model.entity.dynamicEntity.player.Player;

public interface Command<T> {

    void execute(T receiver);
}
