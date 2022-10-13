package vg.controller;

import javafx.scene.input.KeyCode;

/**
 * The state controller is the controller of a "state" of the software.
 * The states can be either a game in progress, paused or menu state.
 * @param <V> the type of view
 */
public interface StateController<V> {
    /**
     * Returns the view controlled by the controller.
     * @return the view
     */
    V getView();

    /**
     * Sets the view of the controller.
     * @param view the view that will be bound
     */
    void setView(V view);
    /**
     * Captures a key pressed event from the view and
     * transform it into a {@link KeyAction}.
     * @param key the key pressed
     * @return {@link KeyAction}
     */
    KeyAction captureKeyEvent(KeyCode key);

    /**
     * Based on what state the software currently is,
     * certain keys will do certain actions and this
     * method executes the correct one.
     * @param e {@link KeyAction}
     */
    void activatesEvent(KeyAction e);

    /**
     * Overloading of the above method but this will
     * actually change the state to another.
     * @param e {@link StateType}
     */
    void activatesEvent(StateType e);

    /**
     * Returns the current setting of bindings from key to actions.
     * @return {@link KeyEventImpl}
     */
    KeyEventImpl getKeyEventSettings();

    /**
     * Setter for the {@link KeyEventVg}.
     * @param keyEventSettings {@link KeyEventImpl}
     */
    void setKeyEventSettings(KeyEventImpl keyEventSettings);
}
