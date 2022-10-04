package vg.model.timedObject;

public class Shield extends TimedObjectImpl {

    public static final double DEFAULT_DURATION = 500;
    /**
     * Shield activation status.
     * */
    private boolean isActive;

    private Shield(final double duration, final boolean isActive) {
        super(duration);
        this.isActive = isActive;
    }

    public static Shield create(final double duration, final boolean isActive) {
        return new Shield(duration, isActive);
    }

    public final boolean isActive() {
        return this.isActive && !this.isTimeOver();
    }

    /**
     * Disable shield.
     * */
    public void disableShield() {
        this.isActive = false;
    }

    /**
     * Enable shield if timeout isn't expired.
     * */
    public void enableShield() {
        this.isActive = !this.isTimeOver();
    }

    /**
     * Updates timer if shield is active.
     * @param elapsedTime {@inheritDoc}
     * */
    @Override
    public void updateTimer(final double elapsedTime) {
        if (this.isActive()) {
           super.updateTimer(elapsedTime);
        }
    }

}
