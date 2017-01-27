package fi.make.brimstone.game;

public abstract class MapObject {

    protected double x;
    protected double y;

    public MapObject(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
