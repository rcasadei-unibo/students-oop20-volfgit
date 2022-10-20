package vg.view.gameOver;

import vg.controller.Controller;
import vg.view.AdaptableView;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

public class GameOverController extends Controller<GameOverView> {

    public GameOverController(final GameOverView view, final ViewManager viewManager) {
        super(view, viewManager);
    }

    @Override
    public void keyTapped(final KeyAction k) {
        if (k == KeyAction.ENTER) {
            this.getViewManager().popScene();
        }
    }

    @Override
    public void keyPressed(final KeyAction k) {

    }

    @Override
    public void keyReleased(final KeyAction k) {

    }
}
