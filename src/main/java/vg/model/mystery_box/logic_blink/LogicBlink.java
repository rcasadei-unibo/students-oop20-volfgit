package vg.model.mystery_box.logic_blink;

public interface LogicBlink {
    /**
     * This method is used to verify if the blink is active.
     * @return true if the blink is active, false otherwise.
     */
    boolean isBlinking();

    void setBlinking(boolean blinking);

    boolean isShow();

    void updateBlinking(long elapsedTime);

    void show();

    void hide();
}
