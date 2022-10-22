package vg.view;

import javafx.scene.Scene;
import vg.controller.Controller;

/**
 * View interface.
 * @param <T> Controller associated to the FXML file.
 */
public interface View<T> {
    /**
     * Return logic controller (that interact with domain) of this view.
     * @return {@link Controller}
     */
    Controller getIoLogicController();

    /**
     * Set logic controller of view that manages input event and call updates method of view.
     * @param ioLogicController controller that controls this view.
     */
    void setIoLogicController(Controller ioLogicController);

    T getViewController();

    /**
     * Get javaFX scene of this view.
     * @return {@link Scene}
     */
    Scene getScene();
}
