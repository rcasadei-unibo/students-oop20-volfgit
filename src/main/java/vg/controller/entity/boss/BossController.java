package vg.controller.entity.boss;

import vg.controller.gameBoard.GameBoardController;

public interface BossController {

    void setInParentNode(GameBoardController gameController);

    void move();
}
