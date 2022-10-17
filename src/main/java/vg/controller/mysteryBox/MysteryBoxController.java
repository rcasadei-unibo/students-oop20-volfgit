package vg.controller.mysteryBox;

import javafx.scene.Node;
import vg.model.mysteryBox.ability.AbilityInTheBox;

public interface MysteryBoxController<T extends AbilityInTheBox> {
    public Node getNode();
}
