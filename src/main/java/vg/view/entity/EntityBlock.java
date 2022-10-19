package vg.view.entity;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;

public interface EntityBlock {

    public void setImage(String pathImage);

    public Node getNode();

    public Vec2d getPosition();

    public void setPosition(Vec2d position);

    public void setImageOverlay(String pathImage);
    public void showImageOverlay();
    public void hideImageOverlay();
}
