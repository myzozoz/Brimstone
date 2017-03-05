package fi.make.brimstone.game.mapobjects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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
     *
     * @param x
     * @param y
     * @param imagePath Path for the image file used for drawing.
     */
    public MapObject(double x, double y, String imagePath) {
        this.x = x;
        this.y = y;
        InputStream is = getClass().getClassLoader().getResourceAsStream(imagePath);
        //ImageIcon i = new ImageIcon(imagePath);
        try {
            BufferedImage bf = ImageIO.read(is);
            this.image = bf;
        } catch (Exception e) {
            System.out.println(e);
        }
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
