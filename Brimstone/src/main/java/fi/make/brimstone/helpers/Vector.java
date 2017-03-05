package fi.make.brimstone.helpers;

/**
 * A simple helper class for storing two-dimensional data, like coordinates,
 * speeds, accelerations, etc.
 *
 * @author make
 */
public class Vector {

    /**
     * The first value of the pair.
     */
    public double x;

    /**
     * The second value of the pair.
     */
    public double y;

    /**
     * Initializes the value pair.
     * @param x First value.
     * @param y Second value.
     */
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Can calculate its own absolute distance.
     *
     * @return The absolute distance of the vector's value pair.
     */
    public double getAbs() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }

    @Override
    public String toString() {
        return "( " + x + ", " + y + ")";
    }
}
