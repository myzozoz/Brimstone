package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.FlameDirection;

/**
 * The player class. Possesses methods to update position based on acceleration
 * and dTime.
 *
 * @author make
 */
public class Player extends MapObject {

    private Vector speed;
    private int flameLength;
    private FlameDirection flameDir;

    /**
     * Calls the super constructor.
     *
     * @param x Initial location on x-axis.
     * @param y Initial location on y-axis.
     */
    public Player(double x, double y) {
        super(x, y, Variables.PLAYER_IMAGE);
        speed = Variables.PLAYER_SPEED;
        flameDir = FlameDirection.UP;
    }

    /**
     * Changes the player's location based on the current speed vector. Also
     * updates the flame's length.
     *
     * @param dTime Time since last update (ms).
     */
    public void updatePosition(long dTime) {
        x += speed.x * dTime;
        y += speed.y * dTime;
        setFlameLength();
    }

    /**
     * Accelerates the player based on a constant. Also roofs the player's
     * speed.
     *
     * @param x Direction on the x-axis.
     * @param y Direction on the y-axis
     * @param dTime Time since last update (ms).
     */
    public void accelerate(double x, double y, long dTime) {
//        System.out.println("ACCELERATING");
        speed.x += x * Variables.ACCELERATION_MULTIPLIER * dTime;
        speed.y += y * Variables.ACCELERATION_MULTIPLIER * dTime;
        if (getSpeedAbs() > Variables.PLAYER_MAX_SPEED) {
            setSpeed(Variables.PLAYER_MAX_SPEED);
        }
    }

    /**
     * Decelerates the player. Stops him at 0. Vertical and Horizontal
     * deceleration have been divided in order to not affect each other. (e.g.,
     * the player can accelerate in the 'up' direction, but decelerate in the
     * 'right' direction.
     *
     * @param dTime Time since last update (ms).
     */
    public void decelerateVertical(long dTime) {
        //System.out.println("DECEL_VERT");
        if (speed.y > 0) {
            if (speed.y - Variables.DECELERATION_MULTIPLIER * dTime < 0) {
                speed.y = 0;
            } else {
                speed.y -= Variables.DECELERATION_MULTIPLIER * dTime;
            }
        } else if (speed.y < 0) {
            if (speed.y + Variables.DECELERATION_MULTIPLIER * dTime > 0) {
                speed.y = 0;
            } else {
                speed.y += Variables.DECELERATION_MULTIPLIER * dTime;
            }
        }
    }

    /**
     * Decelerates the player. Stops him at 0. Vertical and Horizontal
     * deceleration have been divided in order to not affect each other. (e.g.,
     * the player can accelerate in the 'up' direction, but decelerate in the
     * 'right' direction.
     *
     * @param dTime Time since last update (ms).
     */
    public void decelerateHorizontal(long dTime) {
        //System.out.println("DECEL_HORI");
        if (speed.x > 0) {
            if (speed.x - Variables.DECELERATION_MULTIPLIER * dTime < 0) {
                speed.x = 0;
            } else {
                speed.x -= Variables.DECELERATION_MULTIPLIER * dTime;
            }
        } else if (speed.x < 0) {
            if (speed.x + Variables.DECELERATION_MULTIPLIER * dTime > 0) {
                speed.x = 0;
            } else {
                speed.x += Variables.DECELERATION_MULTIPLIER * dTime;
            }
        }
    }

    /**
     * Speed vector getter.
     * @return Speed as a vector.
     */
    public Vector getSpeed() {
        return speed;
    }

    /**
     * Speed double getter.
     * @return The absolute speed value.
     */
    public double getSpeedAbs() {
        return Math.sqrt(Math.pow(speed.x, 2) + Math.pow(speed.y, 2));
    }

    /**
     * Direction getter.
     * @return Direction normalized as vector.
     */
    public Vector getDirection() {
        return new Vector(speed.x / getSpeedAbs(), speed.y / getSpeedAbs());
    }

    /**
     * Speeds can be set both via Vector or absolute value (double).
     * @param newSpeed Speeds as a vector.
     */
    public void setSpeed(Vector newSpeed) {
        speed = newSpeed;
    }

    /**
     * Speeds can be set both via Vector or absolute value (double).
     * @param spd Speed as double.
     */
    public void setSpeed(double spd) {
        this.speed.x = getDirection().x * spd;
        this.speed.y = getDirection().y * spd;
    }

    /**
     * X coordinate setter.
     * @param x x location.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Y coordinate setter.
     * @param y y location.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Calculates how long the player's flame should be.
     */
    public void setFlameLength() {
        flameLength = (int) (3.0 * getSpeedAbs());
    }

    /**
     * Flame length getter.
     * @return Length of the player's flame.
     */
    public int getFlameLength() {
        return flameLength;
    }

    /**
     * A getter for the player's flames' direction.
     * @return Direction of the player's flame.
     */
    public FlameDirection getFlameDir() {
        return flameDir;
    }

    /**
     * Setter for the player's flames' direction.
     * @param f A FlameDirction enum value.
     */
    public void setFlameDir(FlameDirection f) {
        flameDir = f;
    }
}