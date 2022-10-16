package vg.controller;

import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.View;
import vg.view.ViewManager;

public abstract class Controller implements SceneController {
    /**
     * View to be controlled.
     */
    private AdaptableView view;
    /**
     * View manager used to add new view to application window.
     */
    private ViewManager viewManager;

    public Controller(final AdaptableView view, final ViewManager viewManager) {
        this.view = view;
        this.viewManager = viewManager;
    }

    /**
     * @return view that depends on this controller
     */
    public AdaptableView getView() {
        return this.view;
    }

    /**
     * @return viewManager used by this controller to add new views to application's window
     */
    public ViewManager getViewManager() {
        return viewManager;
    }
}
