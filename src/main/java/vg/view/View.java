package vg.view;


import javafx.scene.Scene;
import vg.controller.Controller;

public interface View {
    /**
     * @return controller of view.
     */
    Controller getIoLogicController();

    /**
     * Set controller of view.
     * @param ioLogicController controller that controls this view.
     */
    void setIoLogicController(Controller ioLogicController);
    Scene getScene();
}
