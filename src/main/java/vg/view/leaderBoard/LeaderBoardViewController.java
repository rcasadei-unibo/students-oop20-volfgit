package vg.view.leaderBoard;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import vg.view.ViewController;

import java.util.Optional;

public class LeaderBoardViewController extends ViewController {

    @FXML
    private Label closeBtn;

    @FXML
    private VBox list;

    @FXML
    private Separator sep1;

    @FXML
    private Separator sep2;

    public void closeBtnPressing() {
        closeBtn.setTextFill(Paint.valueOf("#fff600"));
    }

    public void showList() {
        //TODO: showList(Data data) refresh list with updated data

        for (int i = 0; i < 20; i++) {
            Optional<Node> itemRow = LeaderBoardView.listItem(i, i*2, 0);
            itemRow.ifPresent(node -> list.getChildren().add(node));
        }
    }

}
