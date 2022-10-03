package vg.input;

import vg.model.entity.dynamicEntity.player.Player;

public interface Command {

    void execute(Player player);
}
