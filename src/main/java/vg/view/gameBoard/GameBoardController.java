package vg.view.gameBoard;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class GameBoardController {
    @FXML
    public BorderPane borderPane;

    @FXML
    public Button mainMenuButton;
    @FXML
    private Pane gameArea;
    private String gameAreaProve = "#gameArea";


    private void initialize() {
        try {
            gameArea.lookup(gameAreaProve).setStyle("-fx-background-color: #ff08d7;");
        } catch (Exception e) {
            System.out.println("NOOOO");
        };
    }
    @FXML
    private void gameAreaClicked() {
        System.out.println("gameAreaClicked");
    }

    public void stampa() {
        System.out.println("Entro in stampa");
        initialize();
    }


    public void mainMenuButtonClicked(MouseEvent mouseEvent) {
        System.out.println("Button clicked");
    }

}
