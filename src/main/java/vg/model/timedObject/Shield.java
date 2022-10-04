package vg.model.timedObject;

import vg.model.timedObject.TimedObjectImpl;

public class Shield extends TimedObjectImpl {

    /**
     * Shield activation status.
     * */
    private boolean isActive;

    public Shield(final double duration, final boolean isActive) {
        super(duration);
        this.isActive = isActive;
    }

    public final boolean isActive() {
        return this.isActive;
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
        if (!this.isTimeOver()) {
            this.isActive = true;
        }
    }

    /**
     * Updates timer if shield is active.
     * @param elapsedTime {@inheritDoc}
     * */
    @Override
    public void updateTimer(final double elapsedTime) {
        if (this.isActive) {
           super.updateTimer(elapsedTime);
        }
    }

}
