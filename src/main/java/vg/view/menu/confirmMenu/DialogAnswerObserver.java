package vg.view.menu.confirmMenu;

/**
 * Interface to notify controller which was the selection of confirmation dialog.
 */
public interface ResumeObserver {
    void notifyDialogAnswer(ConfirmOption answer);
}
