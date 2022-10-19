package vg.controller.player;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.controller.gameBoard.GameBoardController;

public interface PlayerViewController {
    void setPosition(Vec2d position);
    Node getNode();
}
