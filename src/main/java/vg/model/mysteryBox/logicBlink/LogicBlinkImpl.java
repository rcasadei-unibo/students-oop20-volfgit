package vg.model.mysteryBox.logicBlink;

public class LogicBlinkImpl implements LogicBlink {

    private boolean isBlinking;

    private final double timeHide;
    private final double timeShow;

    public LogicBlinkImpl() {
        this.isBlinking = false;
        this.timeHide = 0.5;
        this.timeShow = 0.5;
    }

    @Override
    public boolean isBlinking() {
        return this.isBlinking;
    }

    @Override
    public void setBlinking(boolean blinking) {
        this.isBlinking = blinking;
    }
}
