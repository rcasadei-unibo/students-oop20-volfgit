package vg.utils;

/**
 * Enum that defines possible tier of weight of entities.
 * Entities will bounce after a collision only if the other
 * entity is in a MassTier equal or higher. NOCOLLISION is
 * a mass tier that defines entities which cannot bounce.
 */
public enum MassTier {
    /**
     * HIGH : this is the mass tier for borders and bosses.
     */
    HIGH,
    /**
     * MEDIUM : this is the mass tier for minor enemy such
     * as Mosquitoes.
     */
    MEDIUM,
    /**
     * LOW : this mass tier is not used for any Entity
     * at the present time.
     */
    LOW,
    /**
     * NOCOLLISION : this mass tier is the lowest one
     * and defines entities that will not bounce even if
     * colliding with other enties in this mass tier.
     */
    NOCOLLISION;
    //TODO creare un metodo che controlli se la mass tier è maggiore uguale e diversa da NOCOLLISION
}
