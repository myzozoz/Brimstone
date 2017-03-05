package fi.make.brimstone.game.mapobjects.flames;

import fi.make.brimstone.helpers.Variables;

/**
 * A flame object that points downwards.
 *
 * @author make
 */
public class DownFlame extends Flame {

    /**
     * Calls the super constructor.
     *
     * @param x x location.
     * @param y y location.
     */
    public DownFlame(double x, double y) {
        super(x, y, Variables.FLAME_DOWN_IMAGE);
    }

}
