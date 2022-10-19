package vg.model;

import vg.model.levels.LEVEL;

/**
 * Factory interface for creating {@link Map}.
 * @param <T> the type of position, usually {@link vg.utils.V2D}
 * @see Map
 * @see vg.utils.V2D
 * @see Stage
 */
public interface MapFactory<T> {
    /**
     * Using an enum as an entry point, generates a playable map.
     * Usually for a standard level this will be used.
     * @param lv the
     * @return the generated map
     */
    Map<T> fromEnum(LEVEL lv);

    /**
     * If the save staved is saved in a file, this will read the
     * file and generate the correct map from data written in the
     * file after correctly parsing them.
     * @return the generated map
     */
    Map<T> fromFile();

    /**
     * Similar to the {@link #fromFile()} but the data are directly
     * passed to this method and must only be parsed.
     * @return the generated map
     */
    Map<T> fromData();
}
