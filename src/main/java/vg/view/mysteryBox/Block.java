package vg.view.mysteryBox;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;

public interface Block {

    public void setImage(String pathImage);

    public Node getNode();

    public Vec2d getPosition();
}
