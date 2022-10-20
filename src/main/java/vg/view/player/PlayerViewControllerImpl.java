package vg.view.player;

import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import vg.utils.V2D;
import vg.utils.path.PathImagePlayer;
import vg.view.entity.EntityBlock;
import vg.view.entity.EntityBlockImpl;
import vg.view.entity.StaticFactoryEntityBlock;


public class PlayerViewControllerImpl extends EntityBlockImpl implements PlayerViewController {

    public PlayerViewControllerImpl() {
        super(new V2D(0,0), new Dimension2D(40, 40));
        this.setImage(PathImagePlayer.PLAYER);
    }

    @Override
    public void showShield() {
        //this.setImage();
    }

    @Override
    public void hideShield() {
        this.setImage(PathImagePlayer.PLAYER);
    }
}