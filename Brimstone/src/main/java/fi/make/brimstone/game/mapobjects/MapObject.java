package fi.make.brimstone.game.mapobjects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Abstract class template for drawable objects on the map. MapObjects need to
 * have a location on the map and an Image.
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
     * The constructor sets the Image and initial location of the object.
     *
     * @param x x location.
     * @param y y location.
     * @param imagePath Path for the image file used for drawing.
     */
    public MapObject(double x, double y, String imagePath) {
        this.x = x;
        this.y = y;
        InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath);
        try {
            BufferedImage bf = ImageIO.read(is);
            this.image = bf;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * X coordinate getter.
     * @return x location.
     */
    public double getX() {
        return x;
    }

    /**
     * Y coordinate getter.
     * @return y location.
     */
    public double getY() {
        return y;
    }

    /**
     * Image getter.
     * @return The image.
     */
    public Image getImage() {
        return image;
    }
}
