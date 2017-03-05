package fi.make.brimstone.game.mapobjects.flames;

import fi.make.brimstone.helpers.Variables;

/**
 * A flame object that points to the right.
 *
 * @author make
 */
public class UpFlame extends Flame {

    /**
     * Calls the super constructor.
     *
     * @param x x location.
     * @param y y location.
     */
    public UpFlame(double x, double y) {
        super(x, y, Variables.FLAME_UP_IMAGE);
    }

}
