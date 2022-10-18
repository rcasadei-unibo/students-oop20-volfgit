package vg.view.menu.confirmMenu;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

public class DialogConfirmController extends Controller<ConfirmView> {
    private ConfirmOption selection = ConfirmOption.DENY;
    private final DialogAnswerObserver dialogAnswerObserver;

    public DialogConfirmController(final ConfirmView view,
                                   final ViewManager viewManager,
                                   final DialogAnswerObserver dialogAnswerObserver) {
        super(view, viewManager);
        this.dialogAnswerObserver = dialogAnswerObserver;
        this.selectDeny();
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
        this.dialogAnswerObserver.notifyDialogAnswer(this.selection);
    }

    private void selectConfirm() {
        this.getView().selectConfirm();
        this.selection = ConfirmOption.CONFIRM;
    }

    private void selectDeny() {
        this.getView().selectDeny();
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
