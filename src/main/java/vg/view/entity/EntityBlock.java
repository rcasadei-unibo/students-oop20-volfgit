package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.utils.V2D;

public interface EntityBlock {


    V2D getPosition();

    void setPosition(V2D position);
    void setImage(String pathImage);
    void setInParentNode(ObservableList<Node> gameAreaNode);
    void setImageOverlay(String pathImage);


    void showImageOverlay();
    void hideImageOverlay();

    void showCollider();
    void hideCollider();

    void setShow(boolean show);
}
