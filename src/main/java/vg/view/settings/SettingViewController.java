package vg.view.settings;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import vg.view.ViewController;
import vg.view.utils.Colors;

import java.util.List;

import static vg.view.utils.Colors.SELECTED_COLOR;
import static vg.view.utils.Colors.UNSELECTED_COLOR;

public class SettingViewController extends ViewController {

    @FXML
    private Text musicToggle;

    @FXML
    private Text effectsToggle;

    @FXML
    private Text musicLabel;

    @FXML
    private Text effectsLabel;

    @FXML
    private Text quitBtn;

    public void highlightSelectedButton(final int idx) {
        List<Text> buttons = List.of(musicLabel, effectsLabel, quitBtn);
        buttons.forEach(button -> button.setFill(UNSELECTED_COLOR));
        buttons.get(idx).setFill(SELECTED_COLOR);
    }

    public void changeMusicStateON(final boolean isOn) {
        changeStateON(this.musicToggle, isOn);
    }

    public void changeEffectStateON(final boolean isOn) {
        changeStateON(this.effectsToggle, isOn);
    }

    private void changeStateON(final Text labelText,final boolean isOn) {
        labelText.setText(isOn ? "ON" : "OFF");
        labelText.setFill(isOn ? SELECTED_COLOR : UNSELECTED_COLOR);
    }
}
