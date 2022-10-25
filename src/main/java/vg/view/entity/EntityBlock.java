package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.utils.V2D;

import java.util.List;

public interface EntityBlock {
    /**
     * @return the position of the entity.
     */
    V2D getPosition();
    /**
     * @param position the position of the entity.
     */
    void setPosition(V2D position);
    /**
     * Set the visible image of the entity.
     * @param show true if the image is visible, false otherwise.
     */
    void setShow(boolean show);
    /**
     * @param animationPathList the list of path of the animation.
     */
    void setAnimation(List<String> animationPathList);
    /**
     * Set the entity in the parent node.
     * @param gameAreaNode the list of node of the game area.
     */
    void setInParentNode(ObservableList<Node> gameAreaNode);
    /**
     * Set the image overlay.
     * @param pathImage the path of the image.
     */
    void setImageOverlay(String pathImage);
    /**
     * Show the image overlay.
     */
    void showImageOverlay();
    /**
     * Hide the image overlay.
     */
    void hideImageOverlay();
    /**
     * Update the next image of the animation.
     */
    void updateAnimation();
}
