package vg.model.entity.staticEntity;

import vg.utils.V2D;

public class BlinkingMysteryBox extends MysteryBox{

    //magari trovare 2 nomi che siano più indicativi
    private boolean hide;
    private boolean appearence;

    BlinkingMysteryBox(V2D position) {
        super(position);
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public boolean isAppearence() {
        return appearence;
    }

    public void setAppearence(boolean appearence) {
        this.appearence = appearence;
    }

    private void changeState(){
        //TODO
    }
}
