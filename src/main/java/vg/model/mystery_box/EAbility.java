package vg.model.mystery_box;

import vg.utils.path.PathImageMysteryBox;

public enum EAbility {

    SCORE(PathImageMysteryBox.COIN_SCORE),
    FREEZE_TIME(PathImageMysteryBox.COIN_TIME),
    SPEED_UP(PathImageMysteryBox.COIN_SPEED),
    KILL_ALL_MOSQUITOES(PathImageMysteryBox.COIN_KILL_ALL_MOQUETOES);

    private final String pathReveled;

    EAbility(final String pathReveled) {
        this.pathReveled = pathReveled;
    }

    public String getPathReveled() {
        return pathReveled;
    }


    public static EAbility randomAll()  {
        return values()[(int) (Math.random() * values().length)];
    }

}
