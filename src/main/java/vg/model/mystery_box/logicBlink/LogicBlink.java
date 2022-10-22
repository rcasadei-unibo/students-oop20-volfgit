package vg.model.mystery_box.logicBlink;

public interface LogicBlink {

    boolean isBlinking();

    void setBlinking(boolean blinking);

    boolean isShow();

    void updateBlinking(long elapsedTime);
}
