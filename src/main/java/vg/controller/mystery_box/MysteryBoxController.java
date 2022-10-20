package vg.controller.mystery_box;

import com.sun.javafx.geom.Vec2d;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.utils.V2D;

public interface MysteryBoxController<T extends AbilityInTheBox> {

    V2D getPosition();

    void setPosition(V2D position);

    public void setInParentNode(ObservableList<Node> gameAreaNode);
}
