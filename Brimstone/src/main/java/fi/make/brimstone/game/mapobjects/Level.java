package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.game.mapobjects.MapObject;
import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.Vector;

/**
 *
 * @author make
 */
public class Level extends MapObject {

    /**
     *
     * @param x
     * @param y
     */
    public Level(double x, double y) {
        super(x, y, Variables.LEVEL_0_IMAGE);
    }

    /**
     *
     * @return Returns the width and height of the map's image file.
     */
    public Vector getLevelDimensions() {
        return new Vector(image.getWidth(null), image.getHeight(null));
    }

}
