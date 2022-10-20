package vg.controller.mystery_box;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.utils.V2D;

public interface MysteryBoxController<T extends AbilityInTheBox> {
    Node getNode();

    Vec2d getPosition();

    void setPosition(V2D position);

}
