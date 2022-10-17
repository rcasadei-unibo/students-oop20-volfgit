package vg.view.gameBoard;

import javafx.scene.Scene;
import vg.controller.GameController;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.LoadFxmlUtils;
import vg.utils.V2D;
import vg.view.AdaptableView;

public class GameBoardView extends AdaptableView {

    protected GameBoardView() {
        super(new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml")));
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
    * se fai this.getScene() ottieni la scena del gioco che viene poi visualizzata
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
