package vg.controller.mysteryBox;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.model.mysteryBox.AbilityInTheBox;

public interface MysteryBoxController<T extends AbilityInTheBox> {
    public Node getNode();

    public Vec2d getPosition();

    public void setPosition(Vec2d position);

}
