package vg.input;

import vg.model.entity.dynamicEntity.player.Player;

public interface Command<T> {

    /**
     * Execute command calling an action method on receiver.
     * (Pattern Command)
     * @param receiver Receiver object that call action method
     */
    void execute(T receiver);
}
