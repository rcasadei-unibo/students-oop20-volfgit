package vg.view.menu.confirmMenu;

/**
 * Interface to notify controller which was the selection of confirmation dialog.
 */
public interface DialogAnswerObserver {
    void notifyDialogAnswer(ConfirmOption answer);
}
