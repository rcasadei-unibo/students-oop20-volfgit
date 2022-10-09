package vg.view;

import vg.controller.MainController;
import vg.controller.StateController;

/**
 * A view that resize and correctly puts elements on the screen
 * based on the resolution.
 */
public abstract class AdaptableView implements View<StateController<AdaptableView>> {
    /**
     * This draw must use {@link vg.view.utils.ScreenLoader} utilities when
     * implemented to resize correctly.
     */
    @Override
    public void draw() {
    }
}
