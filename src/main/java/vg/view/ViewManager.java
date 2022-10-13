package vg.view;

import javafx.scene.Scene;
import vg.controller.StateController;

import java.util.concurrent.ExecutionException;

public interface ViewManager<V> {
    /**
     * Add new scene to the stack of views and show it.
     * @param scene new scene view to be shown.
     */
    void addScene(final Scene scene, final StateController<V> controller);

    /**
     * Removed last-added scene view from stack and show the previous one.
     */
    void popScene() throws ExecutionException;
}
