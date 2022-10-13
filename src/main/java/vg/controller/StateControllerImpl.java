package vg.controller;

import javafx.scene.input.KeyCode;
import vg.view.AdaptableView;
import vg.view.utils.KeyAction;
import vg.view.utils.KeyEventHandler;

public class StateControllerImpl implements StateController<AdaptableView> {
    /**
     * The view bound to this controller.
     */
    private AdaptableView view;
    /**
     * The settings bound to keys.
     */
    private KeyEventHandler keyEventSettings;
    /**
     * {@inheritDoc}
     */
    @Override
    public AdaptableView getView() {
        return this.view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setView(final AdaptableView view) {
        this.view = view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeyAction captureKeyEvent(final KeyCode key) {
        return getKeyEventSettings().keyPressed(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activatesEvent(final KeyAction e) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activatesEvent(final StateType e) {

    }
    public KeyEventHandler getKeyEventSettings() {
        return keyEventSettings;
    }

    public void setKeyEventSettings(final KeyEventHandler keyEventSettings) {
        this.keyEventSettings = keyEventSettings;
    }

}
