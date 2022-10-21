package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.model.mysteryBox.dataRound.DataRound;
import vg.utils.V2D;

public interface MysteryBoxController<T extends AbilityInTheBox> {

    V2D getPosition();

    void setPosition(V2D position);
    void setBlinking(boolean blinking);

    public void setInParentNode(ObservableList<Node> gameAreaNode);

    public void setDataRound(DataRound dataRound);

    public void updateBlinking(long elapsedTime);

    public void setImage(String mysteryBoss);

    public void checkCollision(Player player);
}
