package vg.model.mysteryBox;

import vg.utils.ThreadUtils;

public abstract class AbstractAbilityDurable extends AbstractAbility implements Runnable {
    private static final int INIT_DURATION = 0;
    private  static final int STEP_TIME = 1;

    private final Thread thread;
    private final int durationMillis;

    private AbilityDuration objectDuration;
    private int currentDurationMillis;
    private boolean isRunning;


    public AbstractAbilityDurable(String pathReveled, int durationMillis) {
        super(pathReveled);
        this.durationMillis = durationMillis;
        this.currentDurationMillis = INIT_DURATION;
        this.thread = new Thread(this);
        this.thread.start();
    }


    protected void onStart(AbilityDuration objectDuration) {
        this.isRunning = true;
        this.objectDuration = objectDuration;
        this.objectDuration.functionCallOnStart();
    }

    private void stop() {
        this.isRunning = false;
        this.objectDuration.functionCallOnEnd();
        this.currentDurationMillis = INIT_DURATION;
    }
    private void onStop() {
        if(this.currentDurationMillis >= this.durationMillis) {
            this.stop();
        }
    }
    private void increaseCurrentDuration() {
        this.currentDurationMillis += STEP_TIME;
    }

    @Override
    public void run() {
        while (true) {
            if(this.isRunning){
                this.increaseCurrentDuration();
                this.onStop();
            }
            ThreadUtils.sleep(1);
        }
    }

}
