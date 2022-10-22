package vg.model.mystery_box.logicBlink;

public class LogicBlinkImpl implements LogicBlink {

    private static final int TIME_HIDE = 3000;
    private static final int TIME_SHOW = 4000;
    private boolean isBlinking;
    private boolean isShow;
    private final double timeHide;
    private final double timeShow;
    private double currentTime;


    public LogicBlinkImpl() {
        this.isBlinking = false;
        this.isShow = true;
        this.timeHide = TIME_HIDE;
        this.timeShow = TIME_SHOW;
        this.currentTime = 0;
    }

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

    private void resetCurrentTime() {
        this.currentTime = 0;
    }
    @Override
    public void updateBlinking(final long elapsedTime) {
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
