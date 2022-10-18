package vg.view.leaderBoard;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

public class LeaderBoardController extends Controller<LeaderBoardView> {

    public LeaderBoardController(final LeaderBoardView view, final ViewManager viewManager) {
        super(view, viewManager);
    }


    //TODO: here load from file list of player and theri scores, after load update view

    @Override
    public void keyTapped(final KeyAction k) {
    }

    @Override
    public void keyPressed(final KeyAction k) {
        if (k == KeyAction.ENTER) {
            this.getView().getViewController().closeBtnPressing();
        }

    }

    @Override
    public void keyReleased(final KeyAction k) {
        if (k == KeyAction.ENTER) {
            this.getViewManager().popScene();
        }
    }
}
