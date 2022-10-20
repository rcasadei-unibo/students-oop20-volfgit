package vg.view.gameOver;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import vg.view.ViewController;

public class GameOverViewController extends ViewController {

    @FXML
    private Text timeout;

    @FXML
    private Text score;

   public void setCountdown(final int time) {
        this.timeout.setText(String.valueOf(time));
    }

    public void setScore(final int score) {
        this.score.setText(String.valueOf(score));
    }

}
