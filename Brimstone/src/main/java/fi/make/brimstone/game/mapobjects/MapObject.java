package fi.make.brimstone.game.mapobjects;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Abstract class template for drawable objects on the map.
 *
 * @author make
 */
public abstract class MapObject {

    /**
     *
     */
    protected double x;

    /**
     *
     */
    protected double y;

    /**
     *
     */
    protected Image image;

    /**
     *
     * @param x
     * @param y
     * @param imagePath Path for the image file used for drawing.
     */
    public MapObject(double x, double y, String imagePath) {
        this.x = x;
        this.y = y;
        ImageIcon i = new ImageIcon(imagePath);
        image = i.getImage();
    }

    /**
     *
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     *
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @return
     */
    public Image getImage() {
        return image;
    }
}
