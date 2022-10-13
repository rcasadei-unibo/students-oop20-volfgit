package vg.view;

import vg.view.utils.KeyAction;

/**
 * Interface for fxml controllers (single scene).
 */
public interface SceneController {
    /**
     * Based on a {@link KeyAction}, the controller
     * will create an effect.
     * @param k {@link KeyAction}
     */
    void activateEvent(KeyAction k);

}
