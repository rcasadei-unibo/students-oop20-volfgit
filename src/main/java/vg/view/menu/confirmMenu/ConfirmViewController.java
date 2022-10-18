package vg.view.menu.confirmMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

public class ConfirmViewController {

    final static Paint selectedColor = Paint.valueOf("#fff600");
    final static Paint unselectedColor = Paint.valueOf("#515151");

    @FXML
    private Text titleText;

    @FXML
    private Text hintText;

    @FXML
    private Label confirmBtn;

    @FXML
    private Label denyBtn;

    @FXML
    public void highlightConfirm() {
        this.confirmBtn.setTextFill(selectedColor);
        this.denyBtn.setTextFill(unselectedColor);

    }

    @FXML
    public void highlightDeny() {
        this.titleText.setText("DENYYYY");
        this.confirmBtn.setTextFill(unselectedColor);
        this.denyBtn.setTextFill(selectedColor);
    }

}
