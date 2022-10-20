package vg.view.gameOver;

import javafx.fxml.FXML;
import org.w3c.dom.Text;
import vg.view.ViewController;

public class GameOverViewController extends ViewController {

    @FXML
    private Text countdown;

    @FXML
    private Text score;

    public void setCountdown(final int time) {
        this.countdown.setTextContent(String.valueOf(time));
    }

    public void setScore(final int score) {
        this.score.setTextContent(String.valueOf(score));
    }

}
