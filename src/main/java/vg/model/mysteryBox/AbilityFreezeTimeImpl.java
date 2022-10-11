package vg.model.mysteryBox;

import vg.model.mysteryBox.ability.AbilityFreezeTime;

public class AbilityFreezeTimeImpl extends AbstractAbilityDurable implements AbilityFreezeTime {


    public AbilityFreezeTimeImpl(float duration) {
        super(duration);
    }


    @Override
    public void StartFreezeTime() {


        super.Start();
    }



    @Override
    public void run() {
        while (super.isRunning) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
