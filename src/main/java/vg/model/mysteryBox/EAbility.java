package vg.model.mysteryBox;

import vg.utils.path.PathImageMysteryBox;

public enum EAbility {

    Score(PathImageMysteryBox.COIN_SCORE),
    FreezeTime(PathImageMysteryBox.COIN_TIME),
    SpeedUp(PathImageMysteryBox.COIN_SPEED),
    KillAllMosquitoes(PathImageMysteryBox.COIN_KILL_ALL_MOQUETOES),
    WeaponMosquitoes(PathImageMysteryBox.COIN_WEAPON_MOQUETOES),
    WeaponBoss(PathImageMysteryBox.COIN_WEAPON_BOSS);

    private final String pathReveled;

    private EAbility(String pathReveled) {
        this.pathReveled = pathReveled;
    }

    public String getPathReveled() {
        return pathReveled;
    }

}
