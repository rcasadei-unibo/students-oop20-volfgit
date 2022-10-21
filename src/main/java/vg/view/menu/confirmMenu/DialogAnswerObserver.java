package vg.view.menu.confirmMenu;

/**
 * Interface to notify controller that implements that interface which was the selection of confirmation dialog launched by controller.
 */
public interface DialogAnswerObserver {
    /**
     * In base of prompt's answer reflects on logic or domain.
     * @param answer {@link ConfirmOption} value of selected button.
     */
    void notifyDialogAnswer(ConfirmOption answer);
}
