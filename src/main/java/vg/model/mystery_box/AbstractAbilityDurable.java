package vg.model.mystery_box;


import vg.model.timedObject.TimedObject;
import vg.model.timedObject.TimedObjectImpl;

public abstract class AbstractAbilityDurable extends AbstractAbility {
    private static final long serialVersionUID = 1L;

    private final TimedObject timedObject;

    public AbstractAbilityDurable(final EAbility idAbility, final double duration) {
        super(idAbility, ETypeAbility.DURABLE);
        this.timedObject = new TimedObjectImpl(duration);
    }

    public Boolean isTimeOver() {
        return this.timedObject.isTimeOver();
    }

    public void updateTimer(final double elapsedTime) {
          this.timedObject.updateTimer(elapsedTime);
    }

    public double getRemainingTime() {
        return this.timedObject.getRemainingTime();
    }
}
