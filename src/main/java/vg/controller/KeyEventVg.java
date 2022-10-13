package vg.controller;
import javafx.scene.input.KeyCode;

/**
 * Interface that defines how actions and key pressing/releasing
 * will be bound.
 */
public interface KeyEvent {
    /**
     * Returns the action for the specific key pressing event.
     * @param k the key that is pressed
     * @return the correct action to do
     */
    KeyAction keyPressed(KeyCode k);
    /**
     * Returns the action for the specific key is released from being pressed.
     * @param k the key that is released
     * @return the correct action to do
     */
    KeyAction keyReleased(KeyCode k);
}
