package vg.model;

import vg.model.bonus.Bonus;
import vg.model.entity.Entity;

import java.util.Set;

public interface Map<T> {
    boolean isInBorder(Entity toCheck);

    //TODO capire come gestire i bordi dai vettori
    T getBorders();

    double getOccupiedPercentage();

    //Return a list of active bonus collected by player
    Set<Bonus> getActiveBonus();

}
