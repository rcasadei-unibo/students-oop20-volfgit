package vg.view.entity;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.utils.V2D;

public interface EntityBlock {

    public void setImage(String pathImage);

    public Node getNode();

    public V2D getPosition();

    public void setPosition(V2D position);

    public void setImageOverlay(String pathImage);
    public void showImageOverlay();
    public void hideImageOverlay();
}
