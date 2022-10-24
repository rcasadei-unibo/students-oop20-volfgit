package vg.controller.entity.boss;

import vg.controller.gameBoard.GameBoardController;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public interface BossController {

    void setInParentNode(GameBoardController gameController);

    void move();

    void saveMySpeed();

    void setSpeed(V2D v2D);

    void restoreMySpeed();

    void setPosition(V2D v2dPosition);

    V2D getPosition();

    V2D getSpeed();

    Shape getShape();

    MassTier getMassTier();
}
