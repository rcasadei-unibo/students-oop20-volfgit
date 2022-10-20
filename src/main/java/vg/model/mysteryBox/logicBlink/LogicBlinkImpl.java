package vg.model.mysteryBox.logicBlink;

public class LogicBlinkImpl implements LogicBlink {

    private boolean isBlinking;
    private boolean isShow;

    private final double timeHide;
    private final double timeShow;
    private double currentTime;


    public LogicBlinkImpl() {
        this.isBlinking = false;
        this.isShow = true;
        this.timeHide = 3000;
        this.timeShow = 4000;
        this.currentTime = 0;
    }

    @Override
    public boolean isBlinking() {
        return this.isBlinking;
    }

    @Override
    public void setBlinking(boolean blinking) {
        this.isBlinking = blinking;
    }
    @Override
    public boolean isShow() {
        return this.isShow;
    }

    private void resetCurrentTime() {
        this.currentTime = 0;
    }
    @Override
    public void updateBlinking(long elapsedTime) {
        if(!this.isBlinking) {
            return;
        }
        this.currentTime += elapsedTime;

        if (this.isShow) {
            if (this.currentTime >= this.timeShow) {
                this.isShow = false;
                this.resetCurrentTime();
            }
        } else {
            if (this.currentTime >= this.timeHide) {
                this.isShow = true;
                this.resetCurrentTime();
            }
        }
    }



}
