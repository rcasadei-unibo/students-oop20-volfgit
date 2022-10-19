package vg.controller.player;

import com.sun.javafx.geom.Vec2d;
import vg.controller.gameBoard.GameBoardController;

public interface PlayerController {
    public void setPlayerInGameArea(GameBoardController gameBoardController);
    public void setPosition(Vec2d position);
}
