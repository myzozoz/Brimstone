package fi.make.brimstone.game;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class MapObject {

    protected double x;
    protected double y;
    protected Image image;

    public MapObject(double x, double y, String imagePath) {
        this.x = x;
        this.y = y;
        ImageIcon i = new ImageIcon(imagePath);
        image = i.getImage();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
}
