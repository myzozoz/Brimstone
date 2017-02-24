package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.helpers.Variables;

/**
 * The NCU object was originally designed for more general static MapObjects
 * (hence the name), but has only been used for walls for now.
 *
 * @author make
 */
public class NCU extends MapObject {

    /**
     *
     * @param x
     * @param y
     */
    public NCU(double x, double y) {
        super(x, y, Variables.WALL_IMAGE);
    }
}
