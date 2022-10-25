package vg.model.mystery_box.logic_blink;

public final class StaticFactoryBlink {
    private StaticFactoryBlink() {
    }

    public static LogicBlink createLogicBlinkMysteryBox() {
        final int timeHide = 3000;
        final int timeShow = 4000;
        return new LogicBlinkImpl(timeShow, timeHide);
    }

    public static LogicBlink createLogicBlinkPickUp() {
        final int timeHide = 0;
        final int timeShow = 2500;
        return new LogicBlinkImpl(timeShow, timeHide);
    }


}
