package vg.model;

import vg.model.entity.Entity;

public interface Map<T> {
    boolean isInBorder(Entity toCheck);

    //TODO capire come gestire i bordi dai vettori
    T getBorders();

    double getOccupiedPercentage();
}
