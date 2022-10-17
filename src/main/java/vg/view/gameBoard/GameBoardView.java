package vg.view.gameBoard;

import javafx.scene.Scene;
import vg.controller.GameController;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.V2D;
import vg.view.AdaptableView;

public class GameBoardView extends AdaptableView {

    protected GameBoardView(final Scene scene) {
        super(scene);
    }

    /*
    * IN QIETSA CLASSE LU DEVI METTERE TUTTI I METODI CHE POI CHIAMO IO (TEO) DAL GAMECONTROLLER PER
    * AGGIORNARE LA POSZIONE DELLE COSE
    *
    * ESEMPIO:
    *
    * da fare il metodo drawPlayer(V2D position)  dove io ti passo la nuova positione e tu dentro poi
    * fai le tue cose con javafx
    *
    * */
    public void printPlayer(final Player player) {
        System.out.println(player.getPosition().toString());
    }

    @Override
    public void draw() {

    }

    @Override
    public void reset() {

    }
}