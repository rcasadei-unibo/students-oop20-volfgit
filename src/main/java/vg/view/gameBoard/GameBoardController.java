package vg.view.gameBoard;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import vg.view.ViewManager;

public class GameBoardController {

    private ViewManager viewManager;

    public void setViewManager(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public BorderPane gameAreaDue;
    @FXML
    private Pane gameArea = new Pane();

    @FXML
    private void initialize() {
        gameArea.setStyle("-fx-background-color: #ff08d7;");
    }

    @FXML
    private void gameAreaClicked() {
        System.out.println("gameAreaClicked");
    }

    public void stampa() {
        System.out.println("stampa");
        initialize();
    }

    public Pane getGameArea() {
        return gameArea;
    }

}
