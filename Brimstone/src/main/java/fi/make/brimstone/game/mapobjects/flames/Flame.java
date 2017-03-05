package fi.make.brimstone.game.mapobjects.flames;

import fi.make.brimstone.game.mapobjects.MapObject;

/**
 * Extendable flame class, so the MapController class doesn't have to be aware
 * of all the possible flame classes. Has four different childs due to all of
 * them having different image files.
 *
 * @author make
 */
public class Flame extends MapObject {

    /**
     * Calls the super constructor.
     *
     * @param x x location.
     * @param y u location.
     * @param imagePath Path of the image file.
     */
    public Flame(double x, double y, String imagePath) {
        super(x, y, imagePath);
    }

}
