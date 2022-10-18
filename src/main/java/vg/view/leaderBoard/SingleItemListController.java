package vg.view.leaderBoard;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SingleItemListController {
    @FXML
    private Label posText;

    @FXML
    private Label roundText;
    
    @FXML
    private Label scoreText;

    void setValue(final int pos, final int score, final int round) {
        setPosText(pos);
        setScoreText(score);
        setRoundText(round);
    }

    void setPosText(final int pos) {
        this.posText.setText("#" + pos);
    }

    void setRoundText(final int round) {
        this.roundText.setText(String.valueOf(round));
    }

    void setScoreText(final int score) {
        this.scoreText.setText(String.valueOf(score));
    }
}
