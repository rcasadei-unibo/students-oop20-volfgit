package vg.controller.gameBoard;

import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public interface GameBoardController {

    public Dimension2D getGameAreaDimension();

    public Pane getGameArea();

    public void addInGameArea(Node node);
}
