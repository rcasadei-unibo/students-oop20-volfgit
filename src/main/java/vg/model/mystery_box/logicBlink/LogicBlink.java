package vg.model.mystery_box.logicBlink;

public interface LogicBlink {

    public boolean isBlinking();

    public void setBlinking(boolean blinking);

    public boolean isShow();

    public void updateBlinking(long elapsedTime);
}
