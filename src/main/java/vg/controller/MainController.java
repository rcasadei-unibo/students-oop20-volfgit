package vg.controller;

/**
 * The main controller, that will generate the Binder and
 * all the controller-view will communicate through it.
 * @param <C> the type of controller
 * @param <V> the type of view
 */
public interface MainController<C, V> {

    /**
     * Returns the binder.
     * @return the binder
     */
    Binder<C, V> getBinder();

    /**
     * Returns the stateController.
     * @return the stateController
     */
    C getStateController();

    /**
     * Returns the view.
     * @return the view
     */
    V getView();

    /**
     * Sets the key bindings to the state controller.
     * @param stateController the stateController
     */
    void setIOSettings(C stateController);
}
