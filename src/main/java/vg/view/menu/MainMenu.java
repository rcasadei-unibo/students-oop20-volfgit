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
        getController().activatesEvent(StateType.PLAY);
    }
    @FXML
    private void leaderboardsButtonClicked() {
        getController().activatesEvent(StateType.LEADERBOARDS);
    }
    @FXML
    private void settingsButtonClicked() {
        getController().activatesEvent(StateType.SETTINGS);
    }
    @FXML
    private void controlsButtonClicked() {
        getController().activatesEvent(StateType.CONTROLS);
    }
    @FXML
    private void quitButtonClicked() {
        getController().activatesEvent(StateType.QUIT);
    }
    @Override
    public StateController<AdaptableView> getController() {
        return this.stateController;
    }

    @Override
    public void setController(final StateController<AdaptableView> controller) {
        this.stateController = controller;
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
            case ESCAPE:
                getController().activatesEvent(StateType.QUIT);
                break;
            case ENTER:
                stateController.activatesEvent(StateType.values()[selected]);
                break;
            default:
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
