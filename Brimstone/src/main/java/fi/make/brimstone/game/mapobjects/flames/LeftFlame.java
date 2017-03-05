package fi.make.brimstone.game.mapobjects.flames;

import fi.make.brimstone.helpers.Variables;

/**
 * A flame object that points to the left.
 *
 * @author make
 */
public class LeftFlame extends Flame {

    /**
     * Calls the super constructor.
     *
     * @param x
     * @param y
     */
    public LeftFlame(double x, double y) {
        super(x, y, Variables.FLAME_LEFT_IMAGE);
    }

}
