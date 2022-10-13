package vg.controller;

/**
 * The binder set up communication between a controller
 * and a view, either by creating them or passing each other
 * calling the correct methods.
 * @param <C> the controller
 * @param <V> the view
 */
public interface Binder<C, V> {
    /**
     * Instantiates a controller and a view binding them
     * to each other.
     * @param controller the controller
     * @param view the view
     */
    void init(C controller, V view);

    /**
     * Binds an existing controller to an existing view.
     * @param controller the controller
     * @param view the view
     */
    void bind(C controller, V view);

    V getView();

    C getController();
}
