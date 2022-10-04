package vg.model.timedObject;

public interface Bonus extends TimedObject {
 /**
     * @return Typology of bonus collected by player 
     */
    BonusType getType();
}
