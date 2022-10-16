package vg.view.controller;

import javafx.geometry.Dimension2D;
import javafx.scene.layout.Pane;

public interface GameBoardController {

    public Dimension2D getGameAreaDimension();

    public Pane getGameArea();
}
