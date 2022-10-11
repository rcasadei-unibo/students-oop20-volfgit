package vg.model.mysteryBox;

public abstract class AbstractAbilityDurable implements Runnable {
    private static final float INIT_DURATION = 0;

    protected boolean isRunning;
    protected final float duration;
    protected float currentDuration;

    public AbstractAbilityDurable(float duration) {
        this.duration = duration;
        this.currentDuration = INIT_DURATION;
    }

    public void Start() {
        this.isRunning = true;
    }

    public void Stop() {
        this.isRunning = false;
        this.currentDuration = INIT_DURATION;
    }


}
