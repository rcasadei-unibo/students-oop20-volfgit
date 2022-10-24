package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.utils.V2D;

import java.util.List;

public interface EntityBlock {
    V2D getPosition();

    void setPosition(V2D position);
    void setAnimation(List<String> animationPathList);
    void setInParentNode(ObservableList<Node> gameAreaNode);
    void setImageOverlay(String pathImage);


    void showImageOverlay();
    void hideImageOverlay();
    void setShow(boolean show);
    void updateAnimation();
}
