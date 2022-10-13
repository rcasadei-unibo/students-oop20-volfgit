package vg.view;

import javafx.scene.Scene;
import javafx.stage.Stage;


public interface ViewManager {
    /**
     * Add new scene to the stack of views and show it.
     * @param scene new scene view to be shown.
     */
    void addScene(final Scene scene/*, final EventHandlerController controller*/);

    /**
     * Removed last-added scene view from stack and show the previous one.
     */
    void popScene();

    Stage getStage();
}
