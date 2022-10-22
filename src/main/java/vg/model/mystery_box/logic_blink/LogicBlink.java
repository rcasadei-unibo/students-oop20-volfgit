package vg.model.mystery_box.logic_blink;

public interface LogicBlink {

    boolean isBlinking();

    void setBlinking(boolean blinking);

    boolean isShow();

    void updateBlinking(long elapsedTime);
}
