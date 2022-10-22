package vg.model.mystery_box.dataRound;

import vg.utils.V2D;

public class DataRoundImpl implements DataRound {
    private final V2D position;
    private final boolean blinking;

    public DataRoundImpl(final V2D position, final boolean blinking) {
        this.position = position;
        this.blinking = blinking;
    }

    @Override
    public V2D getPosition() {
        return this.position;
    }

    @Override
    public boolean isBlinking() {
        return this.blinking;
    }
}
