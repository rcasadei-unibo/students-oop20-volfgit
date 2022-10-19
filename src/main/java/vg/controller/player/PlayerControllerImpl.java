package vg.controller.player;

import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Dimension2D;
import vg.controller.gameBoard.GameBoardController;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.path.PathImagePlayer;
import vg.view.entity.EntityBlock;
import vg.view.entity.StaticFactoryEntityBlock;


public class PlayerControllerImpl implements PlayerController {
    private Player model;
    private final EntityBlock view;

    public PlayerControllerImpl() {
//        this.model = model;
        this.view = StaticFactoryEntityBlock.create(new Dimension2D(40, 40));
        this.view.setImage(PathImagePlayer.PLAYER);
    }

    public void setPlayerInGameArea(GameBoardController gameBoardController) {
        gameBoardController.addInGameArea(this.view.getNode());
    }

    public void setPosition(Vec2d position){
        this.view.setPosition(position);
    }

}
