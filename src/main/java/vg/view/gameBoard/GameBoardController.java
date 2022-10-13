package vg.view.gameBoard;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameBoardController {

    @FXML
    public BorderPane gameAreaDue;
    @FXML
    public Button mainMenuButton;
    @FXML
    private Pane gameArea = new Pane();

    @FXML
    private void initialize() {
        try {
            gameArea.lookup("gameArea").setStyle("-fx-background-color: #ff08d7;");
        } catch (Exception e){
            System.out.println("mah");
        };
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

    public void mainMenuButtonClicked(MouseEvent mouseEvent) {
        System.out.println("button clicked");
        //gameArea = GameBoard.loadMainMenu();
    }
}
