package vg.view.leaderBoard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

public class LeaderBoardViewController {

    @FXML
    private Label closeBtn;

    @FXML
    private VBox list;

    public void closeBtnPressing() {

        closeBtn.setTextFill(Paint.valueOf("#fff600"));
    }

    public void showList() {
        //TODO: refresh list with updated data
        for(int i=0; i< 40; i++) {
            Label lb = new Label("CIAOo");
            lb.setTextFill(Paint.valueOf("#fff600"));
            list.getChildren().add(lb);
        }
    }

}
