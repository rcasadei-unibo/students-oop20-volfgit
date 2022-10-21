package vg.view.menu.confirmMenu;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

/**
 * Controller of {@link ConfirmView} that manage buttons selection and communicate it to parent controller that launched the ConfirmView.
 */
public class DialogConfirmController extends Controller<ConfirmView> {
    /**
     * Prompt selection. By default is {@link ConfirmOption#DENY}
     */
    private ConfirmOption selection = ConfirmOption.DENY;

    /**
     * CLass that need and wants to know the selection when is confirmed.
     */
    private final DialogAnswerObserver dialogAnswerObserver;

    public DialogConfirmController(final ConfirmView view,
                                   final ViewManager viewManager,
                                   final DialogAnswerObserver dialogAnswerObserver) {
        super(view, viewManager);
        this.dialogAnswerObserver = dialogAnswerObserver;
        this.selectDeny();
    }

    /**
     * Communicate selection o to observer.
     */
    private void applySelection() {
        this.dialogAnswerObserver.notifyDialogAnswer(this.selection);
    }

    /**
     * Highlight confirm button then set selection to CONFIRM.
     */
    private void selectConfirm() {
        this.getView().selectConfirm();
        this.selection = ConfirmOption.CONFIRM;
    }

    /**
     * Highlight deny button then set selection to DENY.
     */
    private void selectDeny() {
        this.getView().selectDeny();
        this.selection = ConfirmOption.DENY;
    }

    /**
     * There are only two buttons and the apply one so this method
     * handles only {@link KeyAction#LEFT}, {@link KeyAction#RIGHT} and {@link KeyAction#ENTER} actions.
     * @param k {@link KeyAction}
     */
    @Override
    public void keyTapped(final KeyAction k) {
        switch (k) {
            case LEFT: selectConfirm(); break;
            case RIGHT: selectDeny(); break;
            case ENTER: applySelection(); break;
            default:
        }
    }

    /**
     * Redirect action to {@link DialogConfirmController#keyTapped(KeyAction)}.
     * @param k {@link KeyAction}
     */
    @Override
    public void keyPressed(final KeyAction k) {
        keyTapped(k);
    }

    /**
     * Unused. Is does nothing.
     * @param k {@link KeyAction}
     */
    @Override
    public void keyReleased(final KeyAction k) {
    }
}
