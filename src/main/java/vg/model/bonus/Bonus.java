package vg.model.bonus;

public interface Bonus extends TimedObject {
 /**
     * @return Typology of bonus collected by player 
     */
    BonusType getType();
}
