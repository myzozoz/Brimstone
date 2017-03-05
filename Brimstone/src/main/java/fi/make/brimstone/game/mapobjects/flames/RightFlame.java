package fi.make.brimstone.game.mapobjects.flames;

import fi.make.brimstone.helpers.Variables;

/**
 * A flame object that points to the right.
 *
 * @author make
 */
public class RightFlame extends Flame {

    /**
     * Calls the super constructor.
     *
     * @param x
     * @param y
     */
    public RightFlame(double x, double y) {
        super(x, y, Variables.FLAME_RIGHT_IMAGE);
    }

}
