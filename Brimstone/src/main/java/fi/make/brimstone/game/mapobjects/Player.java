package fi.make.brimstone.game.mapobjects;

import fi.make.brimstone.helpers.Vector;
import fi.make.brimstone.helpers.Variables;
import fi.make.brimstone.helpers.FlameDirection;
/**
 *
 * @author make
 */
public class Player extends MapObject {

    private Vector speed;
    private double accelConst;
    private double decelConst;
    private int flameLength;
    private FlameDirection flameDir;

    /**
     *
     * @param x Initial location on x-axis.
     * @param y Initial location on y-axis.
     */
    public Player(double x, double y) {
        super(x, y, Variables.PLAYER_IMAGE);
        accelConst = Variables.ACCELERATION_MULTIPLIER;
        decelConst = Variables.DECELERATION_MULTIPLIER;
        speed = Variables.PLAYER_SPEED;
        flameDir = FlameDirection.UP;
    }

    /**
     *
     * @param dTime Time since last update (ms).
     */
    public void updatePosition(long dTime) {
        x += speed.x * dTime;
        y += speed.y * dTime;
        setFlameLength();
    }

    /**
     *
     * @param x Direction on the x-axis.
     * @param y
     * @param dTime Time since last update (ms).
     */
    public void accelerate(double x, double y, long dTime) {
//        System.out.println("ACCELERATING");
        speed.x += x * accelConst * dTime;
        speed.y += y * accelConst * dTime;
        if (getSpeedAbs() > Variables.PLAYER_MAX_SPEED){
            setSpeed(Variables.PLAYER_MAX_SPEED);
        }
    }

    /**
     * Decelerates the player. Stops him at 0.
     *
     * @param dTime Time since last update (ms).
     */
    public void decelerateVertical(long dTime) {
        //System.out.println("DECEL_VERT");
        if (speed.y > 0) {
            if (speed.y - decelConst * dTime < 0) {
                speed.y = 0;
            } else {
                speed.y -= decelConst * dTime;
            }
        } else if (speed.y < 0) {
            if (speed.y + decelConst * dTime > 0) {
                speed.y = 0;
            } else {
                speed.y += decelConst * dTime;
            }
        }
    }

    /**
     *
     * @param dTime Time since last update (ms).
     */
    public void decelerateHorizontal(long dTime) {
        //System.out.println("DECEL_HORI");
        if (speed.x > 0) {
            if (speed.x - decelConst * dTime < 0) {
                speed.x = 0;
            } else {
                speed.x -= decelConst * dTime;
            }
        } else if (speed.x < 0) {
            if (speed.x + decelConst * dTime > 0) {
                speed.x = 0;
            } else {
                speed.x += decelConst * dTime;
            }
        }
    }

    /**
     *
     * @return
     */
    public Vector getSpeed() {
        return speed;
    }
    
    public double getSpeedAbs() {
        return Math.sqrt(Math.pow(speed.x, 2) + Math.pow(speed.y, 2));
    }
    
    public Vector getDirection() {
        return new Vector(speed.x / getSpeedAbs(), speed.y / getSpeedAbs());
    }

    /**
     *
     * @param newSpeed
     */
    public void setSpeed(Vector newSpeed) {
        speed = newSpeed;
    }
    
    public void setSpeed(double speed){
        this.speed.x = getDirection().x * speed;
        this.speed.y = getDirection().y * speed;
    }

    /**
     *
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    
    public void setFlameLength(){
        flameLength = (int)(3.0 * getSpeedAbs());
        System.out.println("flameLength: " + flameLength);
    }
    
    public int getFlameLength(){
        return flameLength;
    }
    
    public FlameDirection getFlameDir(){
        return flameDir;
    }
    
    public void setFlameDir(FlameDirection f){
        flameDir = f;
    }
}
