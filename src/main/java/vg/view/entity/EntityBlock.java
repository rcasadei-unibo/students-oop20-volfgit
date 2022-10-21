package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import vg.utils.Shape;
import vg.utils.V2D;

public interface EntityBlock {


    public V2D getPosition();

    public void setPosition(V2D position);
    public void setImage(String pathImage);
    public void setInParentNode(ObservableList<Node> gameAreaNode);
    public void setImageOverlay(String pathImage);


    public void showImageOverlay();
    public void hideImageOverlay();

    public void showCollider();
    public void hideCollider();

    public void setShow(boolean show);
}
