package vg.view.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import vg.controller.KeyAction;
import vg.controller.StateController;
import vg.controller.StateType;
import vg.view.AdaptableView;

public class MainMenu extends AdaptableView {
    private StateController<AdaptableView> stateController;
    private int selected;
    @FXML
    private Pane panel;
    @FXML
    private Button play;
    @FXML
    private Button leaderboards;
    @FXML
    private Button settings;
    @FXML
    private Button controls;
    @FXML
    private Button quit;
    @FXML
    private void playButtonClicked() {
        stateController.activatesEvent(StateType.PLAY);
    }
    @FXML
    private void leaderboardsButtonClicked() {
        stateController.activatesEvent(StateType.LEADERBOARDS);
    }
    @FXML
    private void settingsButtonClicked() {
        stateController.activatesEvent(StateType.SETTINGS);
    }
    @FXML
    private void controlsButtonClicked() {
        stateController.activatesEvent(StateType.CONTROLS);
    }
    @FXML
    private void quitButtonClicked() {
        stateController.activatesEvent(StateType.QUIT);
    }
    @Override
    public StateController<AdaptableView> getController() {
        return null;
    }

    @Override
    public void setController(final StateController<AdaptableView> controller) {

    }

    @Override
    public KeyEvent getKeyEvent() {
        return null;
    }

    @Override
    public KeyCode getKeyPressed() {
        return null;
    }

    @Override
    public KeyCode getKeyReleased() {
        return null;
    }

    @Override
    public void receiveEventFromController(final KeyAction event) {
        switch (event) {
            case UP:
                if (this.selected > 0) {
                    this.selected--;
                }
                break;
            case DOWN:
                if (this.selected < 4) {
                    this.selected++;
                }
                break;
            case ENTER:
                stateController.activatesEvent(StateType.values()[selected]);
                break;
        }
    }

    @Override
    public void reset() {

    }
    @Override
    public void draw() {

    }
}
