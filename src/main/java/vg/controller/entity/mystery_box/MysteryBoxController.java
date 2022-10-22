package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.dataRound.DataRound;
import vg.utils.V2D;

public interface MysteryBoxController<T extends AbilityInTheBox> {

    V2D getPosition();
    void setPosition(V2D position);
    void setBlinking(boolean blinking);
    void setInParentNode(ObservableList<Node> gameAreaNode);

    void setDataRound(DataRound dataRound);

    void updateBlinking(long elapsedTime);

    void setImage(String mysteryBoss);

    void checkCollision(Player player);
}
