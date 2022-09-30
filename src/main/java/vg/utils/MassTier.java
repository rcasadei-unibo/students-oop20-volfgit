package vg.utils;

/**
 * Enum that defines possible tier of weight of entities.
 * Entities will bounce after a collision only if the other
 * entity is in a MassTier equal or higher. NOCOLLISION is
 * a mass tier that defines entities which cannot bounce.
 */
public enum MassTier {
    HIGH, MEDIUM, LOW, NOCOLLISION;
}
