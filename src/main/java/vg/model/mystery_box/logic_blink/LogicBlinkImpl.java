package vg.model.mystery_box.logic_blink;

public class LogicBlinkImpl implements LogicBlink {
    private boolean isBlinking;
    private boolean isShow;
    private final double timeHide;
    private final double timeShow;
    private double currentTime;


    public LogicBlinkImpl(final int timeShow, final int timeHide) {
        this.isBlinking = false;
        this.isShow = true;
        this.timeShow = timeShow;
        this.timeHide = timeHide;
        this.currentTime = 0;
    }

    /**
     * This method is used to verify the blinking.
     * @return defines if the ability is blinking.
     */
    @Override
    public boolean isBlinking() {
        return this.isBlinking;
    }
    @Override
    public void setBlinking(final boolean blinking) {
        this.isBlinking = blinking;
    }
    @Override
    public boolean isShow() {
        return this.isShow;
    }
    @Override
    public void updateBlinking(final long elapsedTime) {
        if (!this.isBlinking) {
            return;
        }
        this.updateCurrentTime(elapsedTime);

        if (this.isShow) {
            this.updateIfIsShown();
        } else {
            this.updateIfIsHidden();
        }
    }

    private void resetCurrentTime() {
        this.currentTime = 0;
    }
    private void updateCurrentTime(final double elapsedTime) {
        this.currentTime += elapsedTime;
    }
    private void updateIfIsShown() {
        if (this.currentTime >= this.timeShow) {
            this.isShow = false;
            this.resetCurrentTime();
        }
    }
    private void updateIfIsHidden() {
        if (this.currentTime >= this.timeHide) {
            this.isShow = true;
            this.resetCurrentTime();
        }
    }

}