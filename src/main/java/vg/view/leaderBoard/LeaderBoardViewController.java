package vg.view.leaderBoard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class LeaderBoardViewController {

    @FXML
    private Label closeBtn;

    public void closeBtnPressing() {
        closeBtn.setTextFill(Paint.valueOf("#fff600"));
    }

}
