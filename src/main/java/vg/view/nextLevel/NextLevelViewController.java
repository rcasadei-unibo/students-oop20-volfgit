package vg.view.nextLevel;

import javafx.fxml.FXML;
import org.w3c.dom.Text;
import vg.view.ViewController;

public class NextLevelViewController extends ViewController {

    @FXML
    private Text countdown;


    public void setCountdown(final int time) {
        this.countdown.setTextContent(String.valueOf(time));
    }

}
