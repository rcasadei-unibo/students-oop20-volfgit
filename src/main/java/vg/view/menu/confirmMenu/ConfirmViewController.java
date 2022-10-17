package vg.view.menu.confirmMenu;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

public class ConfirmViewController extends Controller {
    private ConfirmView confirmView;
    private ConfirmOption selection = ConfirmOption.DENY;
    private ResumeObserver resumeObserver;

    public ConfirmViewController(final ConfirmView view,
                                 final ViewManager viewManager,
                                 final ResumeObserver resumeObserver) {
        super(view, viewManager);
        this.confirmView = view;
        this.confirmView.selectDeny();
        this.resumeObserver = resumeObserver;
    }

    @Override
    public void keyTapped(final KeyAction k) {
        switch (k) {
            case LEFT: selectConfirm(); break;
            case RIGHT: selectDeny(); break;
            case ENTER: applySelection(); break;
            default:
        }
    }

    private void applySelection() {
        this.resumeObserver.notifyDialogAnswer(this.selection);
    }

    private void selectConfirm() {
        this.confirmView.selectConfirm();
        this.selection = ConfirmOption.CONFIRM;
    }

    private void selectDeny() {
        this.confirmView.selectDeny();
        this.selection = ConfirmOption.DENY;
    }

    @Override
    public void keyPressed(final KeyAction k) {
        keyTapped(k);
    }

    @Override
    public void keyReleased(final KeyAction k) {
    }
}
