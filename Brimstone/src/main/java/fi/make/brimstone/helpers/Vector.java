package fi.make.brimstone.helpers;

/**
 * A simple helper class for storing two-dimensional data, like coordinates,
 * speeds, accelerations, etc.
 * @author make
 */
public class Vector {

    public double x;
    public double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Can calculate its own absolute value.
     * @return
     */
    public double getAbs(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    
    @Override
    public String toString() {
        return "( " + x + ", " + y + ")";
    }
}
