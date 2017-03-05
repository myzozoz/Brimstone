package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.Vector;

/**
 * The level class contains the background for the playing board.
 *
 * @author make
 */
public class Level extends MapObject {

    /**
     * The constructor calls the super constructor.
     *
     * @param x x location.
     * @param y y location.
     */
    public Level(double x, double y) {
        super(x, y, Variables.LEVEL_0_IMAGE);
    }

    /**
     * Returns the width and height of the map's image file.
     *
     * @return Returns the width and height of the map's image file.
     */
    public Vector getLevelDimensions() {
        return new Vector(image.getWidth(null), image.getHeight(null));
    }

}
