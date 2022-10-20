package vg.model.mysteryBox.logicBlink;

public class LogicBlinkImpl implements LogicBlink{

    private boolean isBlinking;

    private double timeHide;
    private double timeShow;


    @Override
    public boolean isBlinking() {
        return this.isBlinking;
    }

    @Override
    public void setBlinking(boolean blinking) {
        this.isBlinking = blinking;
    }
}
