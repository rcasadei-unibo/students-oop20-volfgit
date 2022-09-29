package vg.model;

import vg.utils.Position;

public class BlinkingMysteryBox extends MysteryBox{

    //magari trovare 2 nomi che siano più indicativi
    private boolean hide;
    private boolean appearence;

    BlinkingMysteryBox(Position position) {
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
